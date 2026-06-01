class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen=0;
        int j=0,i=0;
        int[] freq=new int[26];
        int maxFreq=0;
        while(j<s.length())
        {
            freq[s.charAt(j)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(j)-'A']);
            while((j-i+1)-maxFreq>k)
            {
                freq[s.charAt(i)-'A']--;
                i++;
            }
            maxLen=Math.max(maxLen,(j-i+1));
            j++;
        }
        return maxLen;
    }
}
