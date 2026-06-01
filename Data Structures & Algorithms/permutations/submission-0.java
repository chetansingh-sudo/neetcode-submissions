class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,0);
        return ans;
    }
    public void dfs(int[] arr,int start)
    {
        if(start==arr.length-1)
        {
            List<Integer> list = Arrays.stream(arr)
                           .boxed()
                           .collect(Collectors.toList());
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<arr.length;i++)
        {
            swap(arr,start,i);
            dfs(arr,start+1);
            swap(arr,start,i);
        }
    }
    public void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
