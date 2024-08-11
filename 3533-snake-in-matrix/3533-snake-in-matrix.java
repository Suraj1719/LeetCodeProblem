class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int r=0;
        int c=0;
        int length=commands.size();
        for(String s:commands){
            System.out.println(s);
            System.out.println(s.equals("RIGHT"));
            System.out.println(s.equals("LEFT"));
            System.out.println(s.equals("UP"));
            System.out.println(s.equals("DOWN"));
            if(s.equals("RIGHT")){
                c++;
            }
            else if(s.equals("LEFT")){
                c--;
            }
            else if(s.equals("UP")){
                r--;
            }
            else if(s.equals("DOWN")){
                r++;
            }
        }
        return (r*n)+c;
    }
}