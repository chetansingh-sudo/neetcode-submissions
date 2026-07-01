class Solution {
    public String minWindow(String s, String t) {
      String ans="";
      int[] freq=new int[256];
      for(int i=0;i<t.length();i++)
      {
        freq[t.charAt(i)-'0']++;
      }
      int count=t.length(),j=0,i=0;
      int min=Integer.MAX_VALUE;
      while(j<s.length())
      {
        if(freq[s.charAt(j)-'0']>0)
        count--;
        freq[s.charAt(j)-'0']--;
        while(count==0)
        {
            if((j-i+1)<min)
            {
                min=j-i+1;
                ans=s.substring(i,j+1);
            }
            freq[s.charAt(i)-'0']++;
            if(freq[s.charAt(i)-'0']>0)
            count++;
            i++;
        }
        j++;
      }
      return ans;
    }
}
