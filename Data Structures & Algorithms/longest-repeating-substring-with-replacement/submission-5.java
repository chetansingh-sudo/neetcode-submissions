class Solution {
    public int characterReplacement(String s, int k) {
        int maxi=0;
        int max=0;
        int[] freq=new int[26];
        int i=0;
        int j=0;
        while(j<s.length())
        {
          freq[s.charAt(j)-'A']++;
           max=Math.max(freq[s.charAt(j)-'A'],max);
          while ((j - i + 1) - max > k) {
    freq[s.charAt(i) - 'A']--;
    i++;

    max = 0;
    for (int x : freq)
        max = Math.max(max, x);
}
          maxi=Math.max(maxi,j-i+1);
          j++;
        }
        return maxi;
    }
}
