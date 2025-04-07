class Solution {
    public boolean canPartition(int[] arr) {
        //tabulation method for removing extra stack space in memoization
        int totSum=0;
        int n=arr.length;
    
    for(int i=0; i<n;i++){
        totSum+= arr[i];
    }
    
    if (totSum%2==1) 
    return false;
    
    
        int k = totSum/2;
        boolean dp[][]=new boolean[n][k+1];//for each number in array we check we can get target or not till that number
    
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        
        if(arr[0]<=k)
            dp[0][arr[0]] = true;
        
        for(int ind = 1; ind<n; ind++){//array number iteration
            for(int target= 1; target<=k; target++){//checking which target we can get
                
                boolean notTaken = dp[ind-1][target];
        
                boolean taken = false;
                    if(arr[ind]<=target)
                        taken = dp[ind-1][target-arr[ind]];
            
                dp[ind][target]= notTaken||taken;
            }
        }
        
        return dp[n-1][k];
    }
}