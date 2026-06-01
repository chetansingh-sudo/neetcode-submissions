class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        st.push(nums[0]);
        for(int i=1;i<n;i++)
        {
            boolean flag=false;
            while(!st.isEmpty() && st.peek()>0 && nums[i]<0 )
            {
            
            int c=Math.abs(st.peek());
            int d=Math.abs(nums[i]);
            if(d>c)
            {
                st.pop();
                //st.push(nums[i]);
                
            }
            else if(c>d)
            {
                nums[i]=0;
                break;
            }
            else if(d==c)
            {
                st.pop();
                nums[i]=0;
                break;
               
            }
            }
            //if(flag==false)
            if(nums[i]!=0)
            st.push(nums[i]);
            
           
        }
        int[] ans=new int[st.size()];
        int k=0;
        List<Integer> list=new ArrayList<>();
        while(!st.isEmpty())
        {
            list.add(st.pop());
        }
        //list.reverse();
        for(int i=0;i<list.size();i++)
        {
            ans[i]=list.get(list.size()-i-1);
        }
        return ans;
    }
}