class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> st=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<=n-3;i++)
        {
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    st.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                }
                else if(sum>0)
                {
                    k--;
                }
                else
                j++;

            }
        }
        return new ArrayList<>(st);
    }
}
