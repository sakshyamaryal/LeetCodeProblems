
// 997. Find the Town Judge

// In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

// If the town judge exists, then:

// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
// You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

// Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

// Example 1:

// Input: n = 2, trust = [[1,2]]
// Output: 2
// Example 2:

// Input: n = 3, trust = [[1,3],[2,3]]
// Output: 3
// Example 3:

// Input: n = 3, trust = [[1,3],[2,3],[3,1]]
// Output: -1
 

// Constraints:

// 1 <= n <= 1000
// 0 <= trust.length <= 104
// trust[i].length == 2
// All the pairs of trust are unique.
// ai != bi
// 1 <= ai, bi <= n

class Solution {
    public int findJudge(int n, int[][] trust) {
   
        if(trust.length == 0){
            if(n > 1) {
                return -1;
            }else {
                return n;
            }
        }
        
        int ans = -1;
        int[] array = new int[trust.length];
        int[] tustedby = new int[trust.length];
        
        
        for (int i = 0; i < trust.length; i++) {
            array[i] = trust[i][1]; //values collection
            tustedby[i] = trust[i][0]; // keys collection
        }

        int num = array.length;
        int max_count = 0;
        int maxfreq = 0;

        for (int i = 0; i < num; i++) {
            int count = 0;
            for (int j = 0; j < num; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (count > max_count) {
                max_count = count;
                maxfreq = array[i];
            }
        }
        int incrementcounte = 0;
        
        for (int i = 0; i < trust.length; i++) {
            if(array[i] == maxfreq) {
              incrementcounte += 1;
            }else {
              if (maxfreq == tustedby[i]){
                return -1;
              }
            }
        }
        
        
        if(incrementcounte == n-1) {
            return maxfreq;
        }else {
            return -1;
        }
        
    }
}