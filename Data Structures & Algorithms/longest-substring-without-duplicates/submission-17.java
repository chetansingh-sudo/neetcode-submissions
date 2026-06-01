class Solution {
    public int lengthOfLongestSubstring(String ans) {
        int max=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int left=0;
        for(int i=0;i<ans.length();i++)
        {
            while(hm.containsKey(ans.charAt(i)))
            {
 hm.put(ans.charAt(left),hm.get(ans.charAt(left))-1);
 if(hm.get(ans.charAt(left))==0)
 hm.remove(ans.charAt(left));
 left++;
            }
            max=Math.max(max,i-left+1);
            hm.put(ans.charAt(i),1);
        }
        return max;
    }
}
