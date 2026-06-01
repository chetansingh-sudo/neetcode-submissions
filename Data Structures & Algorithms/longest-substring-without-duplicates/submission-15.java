class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1)
        return s.length();
        int i=0;
        int j=0;
        int max=1;
        HashMap<Character,Integer> hm=new HashMap<>();
        boolean flag=false;
        while(j<s.length())
        {
                if(hm.containsKey(s.charAt(j)))
                {
                    flag=true;
                    
                    while(hm.containsKey(s.charAt(j)))
                    {
                        hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                        if(hm.get(s.charAt(i))==0)
                        hm.remove(s.charAt(i));
                        i++;
                        
                    }
                }
                System.out.println(s.charAt(j)+" "+j+" "+i);
                max=Math.max(max,j-i+1);
                hm.put(s.charAt(j),1);
                j++;
        }
        if(flag==false)
        return s.length();

        
        return max;
    }
}
