class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValid(board,i,j,ch)){
                            board[i][j]=ch;

                            if(solve(board)==true)
                            return true;
                            else
                            board[i][j]='.';//backtrack
                        }
                    }
                    return false;
                }
            }
        }
return true;
    }
    boolean isValid(char [][]board,int r,int c,char ch){
        for(int i=0;i<9;i++){
            if(board[i][c]==ch)
            return false;

            if(board[r][i]==ch)
            return false;

            if(board[(3*(r/3))+(i/3)][(3*(c/3))+(i%3)]==ch)//checking in respective 3x3 block
            return false; 
        }
        
        return true;
    }
}