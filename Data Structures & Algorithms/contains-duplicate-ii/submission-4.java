class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int j=0,i=0;
        while(j<n)
        {
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(hm.get(nums[j])>1)
            {
                if(nums[i]==nums[j])
                {
                    if(j-i<=k)
                    return true;
                }
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.get(nums[i])==0)
                    hm.remove(nums[i]);
                i++;
            }

            j++;
        }
        return false;
    }
}