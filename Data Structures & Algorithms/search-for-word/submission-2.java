class Solution {
    int n=0;
    int m=0;
    public boolean dfs(int row,int col,char[][] board,String word,int ind)
    {   
        if(row<0 || row>=n || col<0 || col>=m || board[row][col]=='*' || board[row][col]!=word.charAt(ind) || ind>=word.length())
        {
            return false;    
        }
        if(ind==word.length()-1 && board[row][col]==word.charAt(ind))
        return true;
        char c=board[row][col];
        board[row][col]='*';
        boolean flag= dfs(row+1,col,board,word,ind+1) ||
            dfs(row-1,col,board,word,ind+1) ||
            dfs(row,col+1,board,word,ind+1) ||
            dfs(row,col-1,board,word,ind+1);

            board[row][col]=c;
            return flag;
        
    }
    public boolean exist(char[][] board, String word) {
         n=board.length;
         m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(i,j,board,word,0)==true)
                    return true;
                }
            }
        }
        return false;
    }
}
