class Solution {
    public boolean bs(int[][] matrix,int row,int target)
    {
        int low=0;
        int high=matrix[0].length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(matrix[row][mid]==target)
            return true;
            if(matrix[row][mid]<target)
            {
                low=mid+1;
            }
            else
            high=mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]<=target && matrix[i][m-1]>=target)
            {
                if(bs(matrix,i,target))
                return true;
                else
                return false;
            }
        }
        return false;
    }
}
