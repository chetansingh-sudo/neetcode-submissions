
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        List<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=temp.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && temp[st.peek()]<=temp[i]){
            st.pop();
            }
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
        int[] val=new int[temp.length];
        //int i=0;
        for(int i=0;i<ans.size();i++)
        {
            val[i]=ans.get(ans.size()-i-1);
        }
        return val;
    }
}
