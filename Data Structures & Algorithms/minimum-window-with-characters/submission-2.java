class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[256];
        int count=t.length();
        for(int i=0;i<t.length();i++)
        {
            freq[t.charAt(i)-'0']++;
        }
        int i=0,j=0;
        int min=Integer.MAX_VALUE;
        int ind=-1;
        while(j<s.length())
        {
            if(freq[s.charAt(j)-'0']>0)
            {
                count--;
            }
            freq[s.charAt(j)-'0']--;
            while(count==0)
            {
                if(min>(j-i+1))
                {
                    min=j-i+1;
                    ind=i;
                }
                freq[s.charAt(i)-'0']++;
                if(freq[s.charAt(i)-'0']>0)
                count++;
                i++;
            }
            j++;
        }
        if(ind==-1)
        return "";
        return s.substring(ind,ind+min);
    }
}
