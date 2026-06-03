class Solution {
    public String longestPalindrome(String s) {
       String ans="";
       if(s.length()<=1)
       return s;
       int left=0;
       int right=0;
       for(int i=1;i<s.length();i++)
       {
        left=i;
        right=i;
        while(s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
            if(left<0 || right==s.length())
            {
                break;
            }
        }
        String temp=s.substring(left+1,right);
        if(temp.length()>ans.length())
        {
            ans=temp;
        }
        left=i-1;
        right=i;
        while(s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
            if(left<0 || right==s.length())
            {
                break;
            }
        }
         temp=s.substring(left+1,right);
        if(temp.length()>ans.length())
        {
            ans=temp;
        }
       }
       return ans; 
    }
}
