link : https://practice.geeksforgeeks.org/problems/maximum-and-value-1587115620/1

public static int maxAND (int arr[], int n) {
        
        int res=0, count=0;
        
        for(int bit_ind=31 ; bit_ind>=0 ; bit_ind--){
            count = checkBit(res | (1<<bit_ind), arr, n);
            if(count >= 2)
                res |= (1<<bit_ind);
        }
        
        return res;
    }

    static int checkBit(int pattern, int arr[], int n)
    {
        int count = 0;
        for(int i=0;i<n;i++)
            if((pattern & arr[i]) == pattern)
                ++count;
        return count;
    }
