LC: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram


Approach : Store the freq. of character of both string individually. Now the task is we have to make the frq. of character of String T equal with String S for anagram. 
           So, if frq[c] in String S > frq[c] in String T , just add (frq[c] in S-frq[c] in T) to ans.

  class Solution {
    public int minSteps(String s, String t) {
        int n=s.length();
        int frq1[]=new int[26];
        int frq2[]=new int[26];
        for(int i=0;i<n;i++){
            frq1[s.charAt(i)-'a']++;
            frq2[t.charAt(i)-'a']++;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(frq1[i]>frq2[i]){
                ans+=(frq1[i]-frq2[i]);
            }
        }
    return ans;
    }
}

Approach - 2 (Using HashMap)
  
  class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        // Storing the difference of frequencies of characters in t and s.
        for (int i = 0; i < s.length(); i++) {
            count[t.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }

        int ans = 0;
        // Adding the difference where string t has more instances than s.
        // Ignoring where t has fewer instances as they are redundant and can be covered by the first case.
        for (int i = 0; i < 26; i++) {
            ans += Math.max(0, count[i]);
        }

        return ans;
    }
}
