class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<s1.length();i++)
        {
            freq[s1.charAt(i)-'a']++;
        }
        int count=s1.length();
        int j=0,i=0;
        while(j<s2.length())
        {
          
            if(freq[s2.charAt(j)-'a']>0)
            count--;
              freq[s2.charAt(j)-'a']--;
            while(count==0)
            {
                min=Math.min(j-i+1,min);
                if(min==s1.length())
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
