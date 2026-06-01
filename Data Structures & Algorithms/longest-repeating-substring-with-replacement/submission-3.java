class Solution {
    public int characterReplacement(String s, int k) {
     int[] freq=new int[26];
     int j=0;
     int i=0;
     int max=Integer.MIN_VALUE;
     int val=0;
     while(j<s.length())
     {
        freq[s.charAt(j)-'A']++;
        max=Math.max(max,freq[s.charAt(j)-'A']);
        while((j-i+1)-max>k)
        {
          
            freq[s.charAt(i)-'A']--;

            i++;
        }
          val=Math.max(max,j-i+1);
        j++;
     }   
     return val;
    }
}
