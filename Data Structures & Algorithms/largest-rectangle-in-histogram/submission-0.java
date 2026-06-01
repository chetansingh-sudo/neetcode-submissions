class Solution {
    public int largestRectangleArea(int[] height) {
        int n=height.length;
        int[] pse=new int[n];
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && height[st.peek()]>=height[i])
            {
                st.pop();
            }
            if(st.isEmpty())
                pse[i]=-1;
                else
                pse[i]=st.peek();
                st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && height[st.peek()]>=height[i])
            {
                st.pop();
            }
            if(st.isEmpty())
                nse[i]=n;
                else
                nse[i]=st.peek();
                st.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int width=nse[i]-pse[i]-1;
            max=Math.max(max,width*height[i]);
        }
        return max;
    }
}
