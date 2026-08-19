class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> rowtoNum=new HashMap<>();
        // for(int i=1;i<=n;i++){
        //     rowtoNum.put(i,new HashSet<Integer>());
        // }

        for(int i=0;i<reservedSeats.length;i++){
            int r=reservedSeats[i][0];
            int num=reservedSeats[i][1];

            if(num>=2 && num<=9)
            rowtoNum.computeIfAbsent(r, k -> new HashSet<>()).add(num);

        }

        int ans=2*(n-rowtoNum.size());

        for (Set<Integer> reserved : rowtoNum.values()) {
            boolean leftBlocked = reserved.contains(2) || reserved.contains(3) || 
                                    reserved.contains(4) || reserved.contains(5);
            boolean rightBlocked = reserved.contains(6) || reserved.contains(7) || 
                                     reserved.contains(8) || reserved.contains(9);
            boolean middleBlocked = reserved.contains(4) || reserved.contains(5) || 
                                     reserved.contains(6) || reserved.contains(7);
            
            if (!leftBlocked && !rightBlocked) {
                ans += 2;
            } else if (!leftBlocked || !rightBlocked || !middleBlocked) {
                ans += 1;
            }
            // If all are blocked, we add 0
        }

        return ans;
    }
}