//Using Priority Queue

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

      PriorityQueue<int[]> min_heap = new PriorityQueue<>((x, y) -> {
        if(x[0] != y[0]) {
            return Integer.compare(x[0], y[0]);
        }

        if(x[1] != y[1]) {
            return Integer.compare(x[1], y[1]);
        }

        return 0;
      });
      int row=mat.length;
      int col=mat[0].length;

      for(int i=0;i<row;i++){
        int val=0;
        for(int j=0;j<col;j++){
          if(mat[i][j]==1)val++;
        }
        min_heap.add(new int[]{val,i});
      }
      int ans[]=new int[k];
      int ind=0;
      while(k>0){
        int cur[]=min_heap.peek();
        min_heap.poll();
        ans[ind]=cur[1];
        ind++;
        k--;
      }
    return ans;
    }
}


//Using List-List

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

      List<List<Integer>>val_row=new ArrayList<>();
      
      int row=mat.length;
      int col=mat[0].length;

      for(int i=0;i<=col;i++){
        val_row.add(new ArrayList<>());
      }

      for(int i=0;i<row;i++){
        int val=0;
        for(int j=0;j<col;j++){
          if(mat[i][j]==1)val++;
        }
        val_row.get(val).add(i);
      }

      int ans[]=new int[k];
      int ind=0;
      
      for(int i=0;i<=col;i++){
        List<Integer>cur=val_row.get(i);
        if(cur.size()!=0){
          for(int j=0;j<cur.size() && k>0;j++){
            ans[ind]=cur.get(j);
            ind++;
            k--;
            // if(k==0)
            // break;
          }
        }
      }
    return ans;
    }
}
