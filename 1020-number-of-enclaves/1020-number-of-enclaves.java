class Solution 
{
    public void dfs(int row,int col,boolean[][] vis,int[] delRow,int[] delCol,int[][] grid)
    {
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,vis,delRow,delCol,grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || j==0 || i==n-1 || j==m-1)
                {
                    if(grid[i][j]==1 && vis[i][j]==false)
                    {
                        dfs(i,j,vis,delRow,delCol,grid);
                    }
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1 && vis[i][j] == false) cnt++;
            }
        }
        return cnt;
        
    }
}