class Solution {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int org[]=new int[n];
        org[0]=pref[0];
        int xor=pref[0];
        for(int i=1;i<n;i++){
            org[i]=xor^pref[i];
            xor^=org[i];
        }
        return org;
    }
}
