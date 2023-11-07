class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {

        double[] a = new double[dist.length];//time of monsters to reach the city
        for (int i = 0; i < dist.length; i++) {
            a[i] = (double) dist[i] / speed[i];
        }
        
        Arrays.sort(a);
        int kill_mon = 0;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= i) {
                break;
            }
            
            kill_mon++;
        }
        return kill_mon;
    }
}