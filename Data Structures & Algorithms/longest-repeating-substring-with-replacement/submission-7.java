class Solution {
    public int characterReplacement(String s, int k) {
       int ans=0;
       int max=0;
       int j=0,i=0;
       int[] freq=new int[26];
       int n=s.length();
       while(j<n)
       {
        freq[s.charAt(j)-'A']++;
        max=Math.max(max,freq[s.charAt(j)-'A']);
        while((j-i+1)-max>k)
        {
          freq[s.charAt(i)-'A']--;
          i++;
          max=0;
          for(int val:freq)
          {
            max=Math.max(max,val);
          }
        }
        ans=Math.max(ans,j-i+1);
        j++;
       } 
       return ans;
    }
}
