class Solution {
    boolean flag=false;
    public void dfs(char[][] board,int row,int col,int ind,String word)
    {
        int n=board.length;
        int m=board[0].length;
       
        if(ind<word.length()){
        if(row<0 || row>=n || col<0 || col>= m || board[row][col]!=word.charAt(ind) 
        || board[row][col]=='*')
        return ;
         if(ind==word.length()-1 && board[row][col]==word.charAt(word.length()-1))
        {
            flag=true;
        }
        char c=board[row][col];
        board[row][col]='*';
        dfs(board,row+1,col,ind+1,word);
        dfs(board,row-1,col,ind+1,word);
        dfs(board,row,col+1,ind+1,word);
        dfs(board,row,col-1,ind+1,word);
        board[row][col]=c;
        }
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    dfs(board,i,j,0,word);
                    if(flag==true)
                    return true;
                   
                }
            }
        }
        return false;
    }
}
