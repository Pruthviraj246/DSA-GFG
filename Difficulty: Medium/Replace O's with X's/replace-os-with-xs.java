class Solution {
    public void fill(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        boolean[][] vis=new boolean[n][m];
        for(int j=0;j<m;j++){
            //first row
            if(grid[0][j]=='O' && vis[0][j]==false){
                dfs(0,j,vis,grid,delrow,delcol);
            }
            //last row
            if(grid[n-1][j]=='O' && vis[n-1][j]==false){
                dfs(n-1,j,vis,grid,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){
            //first col
            if(grid[i][0]=='O' && vis[i][0]==false){
                dfs(i,0,vis,grid,delrow,delcol);
            }
            //last col
            if(grid[i][m-1]=='O' && vis[i][m-1]==false){
                dfs(i,m-1,vis,grid,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]=='O'){
                    grid[i][j]='X';
                }
            }
        }
        
    }
    
    static void dfs(int r,int c,boolean[][] vis,char[][] grid,int[] delrow,int[] delcol){
        vis[r][c]=true;
        int n=grid.length;
        int m=grid[0].length;
        
        for(int i=0;i<4;i++){
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]=='O'){
                dfs(nrow,ncol,vis,grid,delrow,delcol);
            }
        }
    }
}
