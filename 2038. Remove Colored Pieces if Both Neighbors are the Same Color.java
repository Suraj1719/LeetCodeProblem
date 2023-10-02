class Solution {
    public boolean winnerOfGame(String colors) {
        int a=0;
        int b=0;
        int n=colors.length();
        for(int i=1;i<n-1;i++){
            if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1)){
                if(colors.charAt(i)=='A')a++;
                else b++;
            }
        }
        System.out.println(a+" "+b);
        return a==0?false:a>b;
    }
}
