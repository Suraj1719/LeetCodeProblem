class Solution {
    public int findMinDifference(List<String> timePoints) {
        int len=timePoints.size();
        int a[][]=new int[len][2];
        int index=0;

        for(String s:timePoints){
            String hour="";
            String sec="";
            boolean vis=false;
            for(int i=0;i<5;i++){
                char ch=s.charAt(i);
                if(ch==':'){
                    //a[index][0]=Integer.valueOf(num);
                    vis=true;
                }else if(vis==true){
                    sec=sec+ch;
                    //a[index][1]=Integer.valueOf(num);
                }else{
                    hour=hour+ch;
                }
                
            }
            a[index][0]=Integer.valueOf(hour);
            a[index][1]=Integer.valueOf(sec);
            index++;
        }
    Arrays.sort(a, new java.util.Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        if(a[0]==b[0])
        return Integer.compare(a[1], b[1]);
        else return Integer.compare(a[0], b[0]);
    }
    });
    int min_minute_diff=Integer.MAX_VALUE;
    for(int i=1;i<len;i++){
        System.out.println(a[i][0]+" "+a[i][1]);
        int h_diff=a[i][0]-a[i-1][0];
        int m_diff=0;
        if(h_diff==0){
            m_diff=a[i][1]-a[i-1][1];
        }else if(h_diff==1){
            h_diff=0;
            m_diff=60+a[i][1]-a[i-1][1];
        }else{
            h_diff--;
            m_diff=60+a[i][1]-a[i-1][1];
        }
        System.out.println(h_diff+" "+m_diff);
        min_minute_diff=Math.min(min_minute_diff,(60*h_diff)+m_diff);
    }
    //for last and first element
    int h_diff=23-a[len-1][0]+a[0][0];
    //System.out.println(a[len-1][0]+" "+a[len-1][1]);
    int m_diff=60-a[len-1][1]+a[0][1];

    //System.out.println(min_minute_diff);
    min_minute_diff=Math.min(min_minute_diff,(60*h_diff)+m_diff);
    return min_minute_diff;
    }
}