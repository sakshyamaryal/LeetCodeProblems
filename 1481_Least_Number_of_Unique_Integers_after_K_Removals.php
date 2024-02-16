<!-- 1481. Least Number of Unique Integers after K Removals
Solved
Medium
Topics
Companies
Hint
Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length -->

<?php class Solution {
    /**
     * @param Integer[] $arr
     * @param Integer $k
     * @return Integer
     */
    function findLeastNumOfUniqueInts($arr, $k) {
        $occurrence = array();
        $newArray = array();

        foreach ($arr as $value) {
            if (array_key_exists($value, $occurrence)) {
                $occurrence[$value]++;
            } else {
                $occurrence[$value] = 1;
            }
        }
        print_r($occurrence);

        asort($occurrence);

        foreach ($occurrence as $value) {
            $newArray[] = $value;
        }

        $sum = 0;

        // for ($i = 0; $i < count($newArray) - 1; $i++) {
        //     if ($newArray[$i] + $sum <= $k) {
        //         $sum += $newArray[$i];
        //         $newArray[$i] = 0;
        //     } else if ($sum + $newArray[$i] > $k && $sum < $k) {
        //         $differece = $newArray[$i] - $sum;
        //         $newArray[$i] -= $differece;
        //         $sum += $differece;
        //         echo $sum;
        //     }
        //     if ($sum >= $k) {
        //         break;
        //     }
        // }

        $consumed_array = $this->consume_vector($newArray, $k);

        $r = 0;

        foreach ($consumed_array as $value){
            if ($value != 0) {
                $r++;
            }
        }

        return $r;
    }

    function consume_vector($vec, $num) {
        $sum = 0;
        for ($i = 0; $i < count($vec); $i++) {
            if ($sum + $vec[$i] <= $num) {
                $sum += $vec[$i];
                $vec[$i] = 0;
            } else if ($sum + $vec[$i] > $num && $sum < $num) {
                $diff = $num - $sum;
                $vec[$i] -= $diff;
                $sum += $diff;
            }
            if ($sum >= $num) {
                break;
            }
        }
        return $vec;
    }
}
