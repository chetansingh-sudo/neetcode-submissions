
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] result=new int[n-k+1];
        for(int i=0;i<k;i++)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
            dq.removeLast();
            dq.offerLast(i);
        }
        result[0]=nums[dq.peekFirst()];
        for(int i=k;i<n;i++)
        {
            if(dq.peekFirst()<=i-k)
            {
                dq.removeFirst();
            }
             while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
            dq.removeLast();
            dq.offerLast(i);
            result[i-k+1]=nums[dq.peekFirst()];

        }
        return result;
    }
}
