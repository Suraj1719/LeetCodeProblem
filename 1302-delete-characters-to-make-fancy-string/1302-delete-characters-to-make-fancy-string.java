class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        int cur_char_count=1;
        char ch=s.charAt(0);
        sb.append(ch);
        int ind=1;
        while(ind<s.length()){
            char cur=s.charAt(ind);
            if(ch==cur){
                cur_char_count++;
            }else{
                ch=cur;
                cur_char_count=1;
            }

            ind++;
            if(cur_char_count>2)continue;
            else sb.append(ch);

            //ind++;
        }
        return sb.toString();
    }
}