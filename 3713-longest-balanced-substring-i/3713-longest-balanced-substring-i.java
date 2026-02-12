// class Solution {
//     public int longestBalanced(String s) {
//         int len=s.length();
//         char str[]=s.toCharArray();
//         int ans=1;int l=1;
//         int r=len;
//         while(l<=r){
//             int mid=(r+l)/2;
//             if(possible(mid,str)){
//                 ans=mid;
//                 l=mid+1;
//             }else{
//                 r=mid-1;
//             }
//         }
//         return ans;
//     }
//     boolean possible(int length, char s[]){
//         for(int i=0;i<s.length-length+1;i++){
//             int frq[]=new int[26];
//             findFrq(i,s,length,frq);
//             if(equalFrq(frq))return true;
//         }
//         return false;
//     }
//     void findFrq(int ind,char s[],int l,int f[]){
//         l=l+ind;
//         while(ind<l){
//             char c=s[ind];
//             f[c-'a']++;
//             ind++;
//         }
//     }

//     boolean equalFrq(int f[]){
//         Set<Integer>hs=new HashSet<>();
//         for(int i=0;i<26;i++){
//             if(f[i]!=0)hs.add(f[i]);
//         }
//         return hs.size()==1;
//     }
// }


class Solution {

    public int longestBalanced(String s) {
        int n = s.length();
        int res = 0;
        int[] cnt = new int[26];

        for (int i = 0; i < n; i++) {//O(len)
            Arrays.fill(cnt, 0);
            for (int j = i; j < n; j++) {//O(len)
                boolean flag = true;
                int c = s.charAt(j) - 'a';
                cnt[c]++;

                for (int x : cnt) { //O(26)
                    if (x > 0 && x != cnt[c]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}