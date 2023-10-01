//Brute Force
class Solution {
    public String reverseWords(String s) {
        //Brute force
        int n=s.length();
        StringBuilder ans=new StringBuilder();
        int left=0;
        for(int i=0;i<n;i++){
            if(i==n-1 || s.charAt(i)==' '){
                if(i==n-1)ans.append(s.charAt(i));
                for(int j=i-1;j>=left;j--){
                    ans.append(s.charAt(j));
                }
                left=i+1;
                if(i!=n-1)ans.append(' ');
            }
            
        }
    return ans.toString();
    }
}

//better approach :


class Solution {
    public String reverseWords(String s) {
        
        int n=s.length();
        StringBuilder ans=new StringBuilder();
        StringBuilder cur=new StringBuilder();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==' '){
                ans.append(cur.reverse().toString()); 
                ans.append(' ');
                cur=new StringBuilder();
            }else{
                cur.append(s.charAt(i));
            }
        }
        ans.append(cur.reverse().toString());
    return ans.toString();
    }
}


//optimal approach : using stack


class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        Stack<Character>st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c==' '){
                while(!st.isEmpty()){
                    ans.append(st.pop());
                }
                ans.append(' ');
            }else{
                st.add(c);
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
    return ans.toString();
    }
}
