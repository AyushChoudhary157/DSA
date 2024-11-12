// 567. Permutation in String
// Solved
// Medium
// Topics
// Companies
// Hint
// Given two strings s1 and s2, return true if s2 contains a 
// permutation
//  of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

 

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false


class Solution {
    public boolean isFreqSame(int[] freq1, int[] freq2){
        for(int i=0; i<26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }
        int windSize = s1.length();

        for(int i=0; i<s2.length(); i++){
            int windIdx = 0, idx = i;
            int[] windFreq = new int[26];

            while(windIdx < windSize && idx < s2.length()){
                windFreq[s2.charAt(idx) - 'a']++;
                windIdx++; idx++;
            }
            if(isFreqSame(freq, windFreq)){
                return true;
            }
        }
        return false;
    }
}
