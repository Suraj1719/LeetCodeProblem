
// Tag : Hard
// Company : Google , Uber , Adobe 
// Que. : https://leetcode.com/problems/arithmetic-slices-ii-subsequence
//YT sol. :https://www.youtube.com/watch?v=cau0JE1q_ZA


//  Approach - BruteForce
  
  class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //find all subsequenc
        //check len and it's AP
        //time : exponential   give tle
        List<List<Integer>>seq=new ArrayList<>();
        List<Integer>cur=new ArrayList<>();
        findsubseq(0,nums,cur,seq);
        int ans=0;
        for(List<Integer>x:seq){
            if(x.size()<3)continue;
            if(isAP(x)==true)ans++;
        }
        return ans;
    }
    boolean isAP(List<Integer>cur){
        int diff=cur.get(1)-cur.get(0);
        for(int i=1;i<cur.size();i++){
            if(cur.get(i)-cur.get(i-1)!=diff)return false;
        }
        return true;
    }
    void findsubseq(int ind,int a[],List<Integer>cur,List<List<Integer>>seq){
        if(ind==a.length){
            seq.add(new ArrayList<>(cur));
            return;
        }

        //take
        cur.add(a[ind]);
        findsubseq(ind+1,a,cur,seq);
        //backtrack
        cur.remove(cur.size()-1);
        //not take
        findsubseq(ind+1,a,cur,seq);
    }
}



// Approach - optimal using DP Technique

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //T.C : O(n^2)
//S.C : O(n^2) - because of the 2D array mp, where each row mp[i] represents a different index in the input vector nums

        int n = nums.length;
        int result = 0;
        Map<Long, Integer>[] mp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            mp[i] = new HashMap<>();
            
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int count_at_j = mp[j].getOrDefault(diff, 0);

                result += count_at_j;
                
                // Increment the count at index i
                mp[i].put(diff, mp[i].getOrDefault(diff, 0) + count_at_j + 1);
            }
        }
        return result;
    }
}
