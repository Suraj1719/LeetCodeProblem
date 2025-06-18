class Solution {
    public boolean validAnagram(int a[],int b[]){
        for(int i=0;i<26;i++){
            if(a[i]<b[i])return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        //approch 1: from index 0 to len-p size tak har substring  check karo
        //time :O(n*m)

        //approach 2: traversal + 26 size of frequency array

        List<Integer> ans=new ArrayList<>();
        int req_frq[]=new int[26];
        int n=s.length();
        int m=p.length();
        if(n<m)return ans;
        for(int i=0;i<m;i++){
            req_frq[p.charAt(i)-'a']++;
        }
        int cur_frq[]=new int[26];
        for(int i=0;i<m-1;i++){
            cur_frq[s.charAt(i)-'a']++;
        }

        int ind=m-1;
        while(ind<n){
            cur_frq[s.charAt(ind)-'a']++;
            if(validAnagram(cur_frq,req_frq))ans.add(ind-m+1);

            cur_frq[s.charAt(ind-m+1)-'a']--;

            ind++;
        }
        return ans;
    }
}