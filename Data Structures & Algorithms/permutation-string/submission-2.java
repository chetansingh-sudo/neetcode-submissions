class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            freq[s1.charAt(i)-'a']++;
        }
        int count=s1.length();
        int i=0,j=0;
        while(j<s2.length())
        {
            if(freq[s2.charAt(j)-'a']>0)
            {
                count--;
            }
            freq[s2.charAt(j)-'a']--;
            while(count==0)
            {
                if((j-i+1)==s1.length())
                return true;
                freq[s2.charAt(i)-'a']++;
                if(freq[s2.charAt(i)-'a']>0)
                count++;
                i++;
            }
            j++;
        }
        return false;
    }
}
