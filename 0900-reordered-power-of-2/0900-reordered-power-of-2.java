class Solution {
    public boolean reorderedPowerOf2(int n) {
        int bArray[]=new int[10];
		bArray=makeArray(n);
		int res[]=new int [10];
		
		for(int i=0;i<31;i++) {
			res=makeArray(1<<i);

			if(isEqual(res,bArray)) {
				return true;
			}
		}
		return false;
        
    }
    private static boolean isEqual(int[] res, int[] bArray) {
		for(int i=0;i<res.length;i++) {
			if(res[i]!=bArray[i])
				return false;
		}
		return true;
	}

	private static int[] makeArray(int n) {
		int temp[]=new int[10];
		while(n>0) {
			temp[n%10]+=1;
			n=n/10;
		}
		return temp;
	}
}