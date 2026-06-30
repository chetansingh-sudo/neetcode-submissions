class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int j=0,i=0;
        int n=s.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        while(j<n)
        {
            
            while(hm.containsKey(s.charAt(j)))
            {
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                if(hm.get(s.charAt(i))==0)
                hm.remove(s.charAt(i));
                i++;
            }
            max=Math.max(max,j-i+1);
            hm.put(s.charAt(j),1);
            j++;
        }
        return max;
    }
}
