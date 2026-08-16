class Solution {
    public boolean stoneGameIX(int[] stones) {
        int count_frq[]=new int[3];// for 0 ,1 ,2 

        for(int x:stones){
            count_frq[x%3]++;
        }

        if(count_frq[0]%2==0){//even number of '0' remainder, then they only act as pass
        return Math.min(count_frq[1],count_frq[2])>0;
        }

        return Math.abs(count_frq[1]-count_frq[2])>2;
    }
}



// class Solution:
//     def stoneGameIX(self, stones: list[int]) -> bool:
//         # Count the remainders
//         cnt = [0, 0, 0]
//         for stone in stones:
//             cnt[stone % 3] += 1
            
//         c0, c1, c2 = cnt[0], cnt[1], cnt[2]
        
//         # Case 1: Even number of Type 0 stones
//         if c0 % 2 == 0:
//             # Alice wins if both Type 1 and Type 2 are present
//             return min(c1, c2) > 0
        
//         # Case 2: Odd number of Type 0 stones
//         # Alice wins if the difference between Type 1 and Type 2 is greater than 2
//         return abs(c1 - c2) > 2