class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans=new ArrayList<>();
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int[] e:intervals)
        {
            if(e[0]>end)
            {
                ans.add(new ArrayList<>(Arrays.asList(start,end)));
                start=e[0];
                end=e[1];
            }
            else
            {
                end=Math.max(end,e[1]);
            }
        }
         ans.add(new ArrayList<>(Arrays.asList(start,end)));
         int[][] arr=new int[ans.size()][2];
         for(int i=0;i<arr.length;i++)
         {
            arr[i][0]=ans.get(i).get(0);
            arr[i][1]=ans.get(i).get(1);
         }
         return arr;
    }
}
