// class Solution {
//     boolean vis[];
//     public boolean sumGame(String num) {
//         char str[]=num.toCharArray();
//         vis=new boolean[str.length];
//         Arrays.fill(vis,false);
//         int count_absent=0;
//         for(char c:str){
//             if(c=='?') count_absent++;
//         }

//         return solve(0,str,count_absent);        
//     }
//     boolean solve(int ind, char s[], int x){
//         if(x==0){
//             int left_sum=0;
//             int right_sum=0;
//             int l=0; int r=s.length-1;
//             while(l<r){
//                 left_sum+=(s[l]-'0');
//                 right_sum+=(s[r]-'0');
//                 l++;
//                 r--;
//             }

//             return left_sum!=right_sum;
//         }

//         if(vis[ind]==true)return true;
//         boolean alice_won=false;
//         for(int j=ind;j<s.length;j++){
//             if(s[j]=='?'){
//         for(int i=0;i<=9;i++){
            
//                 s[j]=(char)(i+'0');
//                 alice_won |= solve(j+1,s,x-1);
//             }
//         }}

//         vis[ind]=true;
//         return alice_won;
//     }
// }





class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        double leftSum = 0, rightSum = 0;
        double leftQ = 0, rightQ = 0;
        
        // Step 1: Count sums and '?' for both halves
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }
        
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }
        
        // Step 2: Check if Bob can force a tie
        // Bob wins (returns false) if: LeftSum - RightSum == 4.5 * (RightQ - LeftQ)
        // We use 4.5 because each pair of '?' contributes 9 (9 / 2 = 4.5)
        return (leftSum - rightSum) != 4.5 * (rightQ - leftQ);
    }
}