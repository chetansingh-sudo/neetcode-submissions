class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character,Integer> hm=new HashMap<>();
       int i=0;
       int max=0;
       int j=0;
       while(j<s.length())
       {
            while(hm.containsKey(s.charAt(j)))
            {

                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                if(hm.get(s.charAt(i))==0)
                hm.remove(s.charAt(i));
                i++;
                

            }
            max=Math.max(max,(j-i+1));
            hm.put(s.charAt(j),1);
            j++;

       }
       
       return max;
    }
}
