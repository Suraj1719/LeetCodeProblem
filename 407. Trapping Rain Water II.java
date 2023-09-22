class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n=heightMap.length;
        int m=heightMap[0].length;
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    pq.add(new Pair(i,j,heightMap[i][j]));
                    vis[i][j]=true;
                }
            }
        }
        int dx[]={-1,0,0,1};
        int dy[]={0,-1,1,0};
        int store_water=0;
        while(!pq.isEmpty()){
            Pair cur=pq.peek();
            pq.poll();
            for(int i=0;i<4;i++){
                int x=dx[i]+cur.row;
                int y=dy[i]+cur.col;
                if(x>=0 && x<n && y>=0 && y<m && vis[x][y]==false){
                    store_water+=Math.max(0,cur.height-heightMap[x][y]);
                    vis[x][y]=true;
                    if(heightMap[x][y]>=cur.height)
                    pq.add(new Pair(x,y,heightMap[x][y]));
                    else
                    pq.add(new Pair(x,y,cur.height));
                }
            }
        }
        return store_water;

    }
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int height;
        public Pair(int row,int col,int height){
            this.row=row;
            this.col=col;
            this.height=height;
        }
        @Override
        public int compareTo(Pair o){
            return this.height-o.height;
        }
    }
}
