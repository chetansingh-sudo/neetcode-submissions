class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
        return "";
    int count=t.length();
    int[] freq=new int[256];
    for(int k=0;k<t.length();k++)
    {
        freq[t.charAt(k)-'A']++;
    }    
    int j=0;
    int i=0;
     int min=Integer.MAX_VALUE;
        int minLength=Integer.MAX_VALUE;
    while(j<s.length())
    {
        if(freq[s.charAt(j)-'A']>0)
        count--;
       
        freq[s.charAt(j)-'A']--;
        while(count==0)
        {
            if(min>(j-i+1))
            {
                min=(j-i+1);
                minLength=i;
            }
            freq[s.charAt(i)-'A']++;
            if(freq[s.charAt(i)-'A']>0)
            count++;
            i++;
        }
        j++;
    }
    if(minLength==Integer.MAX_VALUE)
    return "";
    return s.substring(minLength,minLength+min);
    }
}
