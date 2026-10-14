class Solution {
    public int[] dailyTemperatures(int[] temp) {
      List<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int n=temp.length;
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && temp[st.peek()]<=temp[i])
            st.pop();
            if(st.isEmpty())
            {
                ans.add(0);
            }
            else
            {
                ans.add(st.peek()-i);
            }
            st.push(i);
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }
}
