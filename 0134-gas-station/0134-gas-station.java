// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int len=cost.length;
//         int ans=-1;
//         for(int i=0;i<len;i++){
//             if(gas[i]>=cost[i]){
//                 int end=(i-1+len)%len;
//                 if(possible(i,gas,cost,end,gas[i])==true){
//                 ans=i;
//                 break;
//                 }
//             }
//         }
//         return ans;
//     }
//     boolean possible(int ind,int g[],int c[],int end_pos,int g_tank){
//         if(ind==end_pos && g_tank>=c[ind])return true;

//         boolean result=false;
//         int len=g.length;
//         if(g_tank>=c[ind%len]){
//             result |=possible((ind+1)%len,g,c,end_pos,g_tank-c[ind%len]+
//             g[(ind+1)%len]);
//         }
//         return result;
//     }
// }

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long total_gas=0;
        long total_cost=0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            total_gas+=gas[i];
            total_cost+=cost[i];
        }
        if(total_gas<total_cost)
        return -1;
        long cur_gas=0;int start=0;

        for(int i=0;i<n;i++){
            cur_gas+=gas[i];
            cur_gas-=cost[i];
            if(cur_gas<0){
            start=i+1;//as before ith gas station if we start we always short of gas
            cur_gas=0;
            }
        }
        //as given there is always a ans
        return (int)start;
    }
}