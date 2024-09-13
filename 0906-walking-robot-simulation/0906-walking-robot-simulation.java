class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String>set=new HashSet<>();
        for(int i=0;i<obstacles.length;i++){
            String str=new String();
            str=str+obstacles[i][0];
            str+="-";
            str+=obstacles[i][1];
            set.add(str);
        }
        int dir_move[][]={{0,1},{-1,0},{0,-1},{1,0}};//North,W,S,E
        int cur_dir[]={0,1};//north
        int index=0;
        int x=0;
        int y=0;
        int  maxDis=0;
        for(int i=0;i<commands.length;i++){
            if(commands[i]==-2){//left move
            index=(index+1)%4;
            cur_dir=dir_move[index];
            }else if(commands[i]==-1){//right move
            index=(index-1+4)%4;
            cur_dir=dir_move[index];
            }else{
                for(int step=0;step<commands[i];step++){
                    int new_x=x+cur_dir[0];
                    int new_y=y+cur_dir[1];
                    String nextStep=new String();
                    nextStep=nextStep+new_x;
                    nextStep+="-";
                    nextStep+=new_y;
                    if(set.contains(nextStep))break;

                    x=new_x;
                    y=new_y;

                }
            }
            maxDis=Math.max(maxDis,x*x+y*y);
        }
        return maxDis;
    }
}