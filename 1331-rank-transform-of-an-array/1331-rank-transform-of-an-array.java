class Solution {

    public int[] arrayRankTransform(int[] arr) {
        
        HashMap<Integer, Integer> numToRank = new HashMap<>();
        
        TreeSet<Integer> unique = new TreeSet<>();
        for (int num : arr){
            unique.add(num);
        }
        int rank = 1;
        for (int num : unique) {
            numToRank.put(num, rank);
            rank++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numToRank.get(arr[i]);
        }
        return arr;
    }
}