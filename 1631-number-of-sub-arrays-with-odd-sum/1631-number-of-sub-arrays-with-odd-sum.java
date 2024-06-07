class Solution {
    int mod=1000000007;
    public int numOfSubarrays(int[] arr) {
    
    //     return help(0,0,arr);
    long ans=0;
    int dp[]=new int[arr.length];
    if(arr[0]%2!=0)
    dp[0]=1;

    ans=dp[0];

    for(int i=1;i<arr.length;i++){
        if(arr[i]%2==0){
            dp[i]=dp[i-1];
        }else{
            dp[i]=(i+1)-dp[i-1];
        }
        ans=(ans+dp[i])%mod;
    }
    return (int)ans;


    // long ans = 0, odd = 0, even = 0;
    //     for (int num : arr) {
    //         if (num % 2 == 0) {
    //             even ++;
    //         } else {
    //             long temp = even;
    //             even = odd;
    //             odd = temp;
    //             odd++;
    //         }
    //         ans += odd;
    //     }
    //     return (int)(ans % (Math.pow(10, 9) + 7));
    }
}