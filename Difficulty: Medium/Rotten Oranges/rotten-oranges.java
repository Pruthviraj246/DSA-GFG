class Pair{
    int first;
    int second;
    int time;
    public Pair(int first,int second,int time){
        this.first=first;
        this.second=second;
        this.time=time;
    }
}

class Solution {
    public int orangesRot(int[][] grid) {
        // code here
        int n=grid.length;
                int m=grid[0].length;
                Queue<Pair> q=new LinkedList<>();
                boolean[][] vis=new boolean[n][m];
                int cntFresh=0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(grid[i][j]==2){
                            q.add(new Pair(i,j,0));
                            vis[i][j]=true;
                        }
                        if(grid[i][j]==1){
                            cntFresh++;
                        }
                    }
                }
                int time=0;
                int[] delrow={-1,0,1,0};
                int[] delcol={0,1,0,-1};
                int count=0;
                while(!q.isEmpty()){
                    int r=q.peek().first;
                    int c=q.peek().second;
                    int t=q.peek().time;
                    time=Math.max(time,t);
                    q.remove();
                    for(int i=0;i<4;i++){
                        int nrow=r+delrow[i];
                        int ncol=c+delcol[i];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                            q.add(new Pair(nrow,ncol,time+1));
                            vis[nrow][ncol]=true;
                            count++;
                        }
                    }
                }
                if(count!=cntFresh) return -1;
                return time;
    }
}