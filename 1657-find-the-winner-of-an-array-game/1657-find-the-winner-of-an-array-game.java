class Solution {
    public int getWinner(int[] arr, int k) {
        int num=-1;
        int n=arr.length;

        if(k<n){
            int cur_num=Math.max(arr[0],arr[1]);
            int cur_win_strek=1;
        
            for(int i=2;i<n;i++){

                if(cur_win_strek==k){
                num=cur_num;
                break;
                }

            if(arr[i]>cur_num){
                cur_num=arr[i];
                cur_win_strek=0;
            }
            cur_win_strek++;
            
            }
        }


        if(num==-1){
Arrays.sort(arr);
            num=arr[n-1];
        }

            
        
        
        
        return num;
    }
}