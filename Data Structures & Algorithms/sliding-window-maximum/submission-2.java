class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Stack<Integer> st=new Stack<>();
        int n=nums.length; 
        int[] nge = new int[n];
      

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
  
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<=nums.length-k;i++)
        {
            int j=i;
            while(nge[j]<i+k)
            {
                j=nge[j];
            }
            
                ans.add(nums[j]);
            
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
