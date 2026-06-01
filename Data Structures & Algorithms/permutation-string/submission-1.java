class Solution {
    public boolean checkInclusion(String s, String t) {
        if(s.length()==0)
        return true;
        int min=Integer.MAX_VALUE;
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        int count=s.length();
        int i=0;
        int j=0;
        while(j<t.length())
        {
            if(freq[t.charAt(j)-'a']>0)
            count--;
            freq[t.charAt(j)-'a']--;
            while(count==0)
            {
                min=Math.min(min,j-i+1);
                freq[t.charAt(i)-'a']++;
                if(freq[t.charAt(i)-'a']>0)
                count++;
                i++;
            }
            j++;
        }
        if(min==s.length())
        return true;
        return false;
    }
}