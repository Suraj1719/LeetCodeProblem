class Solution {
    public String sortVowels(String s) {
        int n=s.length();
        char t[]=new char[n];
        PriorityQueue<Integer>v_cap=new PriorityQueue<>();
        PriorityQueue<Integer>v_small=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch!='A' && ch!='E' && ch!='I' && ch!='O' && ch!='U' && ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u')
                t[i]=ch;
            else{
                t[i]='.';
                if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
                v_cap.add(ch-'A');
                else
                   v_small.add(ch-'a'); 
            }
        }
        for(int i=0;i<n;i++){
            if(t[i]=='.'){
                if(v_cap.isEmpty()){
                    int x=v_small.peek();
                    v_small.poll();
                    t[i]=(char)(x+'a');
                }else{
                    int x=v_cap.peek();
                    v_cap.poll();
                    t[i]=(char)(x+'A');
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++)
            ans.append(t[i]);
        return ans.toString();
    }
}