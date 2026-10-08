class Solution {
    public void floydWarshall(int[][] matrix) {
        int n=matrix.length;

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k]!=100000000 && matrix[k][j]!=100000000){
                        matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                    }
                }
            }
        }
    }
}