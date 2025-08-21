class Solution {
    public int numSubmat(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int ans=0;
        //from every index having 1, we tend to fix that position

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    ans+=help(mat,i,j);
                }
            }
        }
        return ans;
    }

    int help(int mat[][],int r,int c){
        int row=mat.length;
        int col=mat[0].length;
        int poss_tri=0;

        int max_pos_width=col;

        int cur_width=0;

        for(int i=r;i<row;i++){

            if(mat[i][c]==0){
                break;
            }
            cur_width=0;
            for(int j=c;j<max_pos_width;j++){
                if(mat[i][j]==0){
                    max_pos_width=j;
                    break;
                }
                cur_width+=1;
            }

            max_pos_width=Math.min(max_pos_width,c+cur_width);
            poss_tri+=(max_pos_width-c);
        }
        return poss_tri;
    }
}