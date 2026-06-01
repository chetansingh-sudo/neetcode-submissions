class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int max=0;
        while(j<s.length())
        {
             hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
            if(hm.get(s.charAt(j))>1)
            {
                while(hm.get(s.charAt(j))>1)
                {
                    hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                    if(hm.get(s.charAt(i))==0)
                    hm.remove(s.charAt(i));
                    i++;
                }
            }
            max=Math.max(max,j-i+1);
           j++;
        }
         return max;
    }
   
}
