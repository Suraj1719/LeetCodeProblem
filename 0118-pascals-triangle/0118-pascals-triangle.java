class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        int size=2;
        List<Integer>cur=new ArrayList<>();
        cur.add(1);
        ans.add(cur);
        while(size<=numRows){
            List<Integer>temp=new ArrayList<>();
            temp.add(1);
            int i=0;
            while(i+1<cur.size()){
                int x=cur.get(i)+cur.get(i+1);
                temp.add(x);
                i++;
            }
            temp.add(1);
            cur=temp;
            temp=new ArrayList<>();
            ans.add(cur);
            size++;
        }
        return ans;
    }
}