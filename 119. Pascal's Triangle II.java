class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>cur=new ArrayList<>();
        cur.add(1);
        if(rowIndex==0)return cur;
        //cur.add(1);
        cur.add(1);
        if(rowIndex==1)return cur;
        for(int i=2;i<=rowIndex;i++){
            List<Integer>temp=new ArrayList<>();
            temp.add(1);
            int size=cur.size();
            for(int j=1;j<size;j++){
                int num=cur.get(j-1)+cur.get(j);
                temp.add(num);

            }
            temp.add(1);
            cur=temp;
        }

    return cur;
    }
}
