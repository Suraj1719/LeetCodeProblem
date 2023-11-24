Approach - 1 : BruteForce(using sorting)

   using sorting time :O(n log n)   space :O(n)
class Solution {
     public int maxCoins(int[] piles) {
  
         Arrays.sort(piles);
         int n=piles.length;
         int ans=0;
         int l=0;
         int r=n-1;
         while(l<r){
             l++;
             r--;
             ans+=piles[r];
             r--;
         }
     return ans;
     }
 }


Approach - 2 (Using Dequeue)
  //using Queue time :O(n)   space :O(n)

class Solution {
    public int maxCoins(int[] piles) {
        
        Arrays.sort(piles);
        ArrayDeque<Integer> queue = new ArrayDeque();
        for (int num : piles) {
            queue.addLast(num);
        }
        
        int ans = 0;
        while (!queue.isEmpty()) {
            queue.removeLast(); // alice
            ans += queue.removeLast(); // us
            queue.removeFirst(); // bob
        }
        
        return ans;
    }
}


