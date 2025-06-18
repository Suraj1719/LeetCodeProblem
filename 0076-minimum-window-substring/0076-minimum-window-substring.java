class Solution {
    List<String>ans;
    public String minWindow(String s, String t) {
        //approach 3: sliding window 

        int m=s.length();
        int n=t.length();
        if(m<n)return "";
        int min_len=n;
        int max_len=m;
        ans=new ArrayList<>();

        while(min_len<=max_len){//binary search   O(log m)
            int mid=min_len+(max_len-min_len)/2;
            //System.out.println(min_len+" "+max_len+" "+mid);
            if(isSubstringPresent(mid,s,t)==true){
                max_len=mid-1;
            }else min_len=mid+1;
        }
        String res="";
        for(String str:ans){
            if(res=="" || str.length()<res.length()){
                res=str;
            }
        }
    return res;
    }
    boolean isSubstringPresent(int len,String s,String t){
        
        int []frq_s=new int[128];
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            frq_s[(int)ch]++;
        }
        int []frq_t=new int[128];
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            frq_t[(int)ch]++;
        }

        if(isEqual(frq_s,frq_t)==true){
        ans.add(s.substring(0,len));
        return true;
        }
        for(int i=len;i<s.length();i++){
            //System.out.println(s.substring(i-len+1,i+1));
            char ch=s.charAt(i);
            frq_s[(int)ch]++;
            char remove=s.charAt(i-len);
            frq_s[(int)remove]--;

            if(isEqual(frq_s,frq_t)==true){
               ans.add(s.substring(i-len+1,i+1));
               return true;
            }
        }
    return false;
    }
    boolean isEqual(int []a,int []b){
        for(int i=0;i<128;i++){
            if(b[i]>a[i])return false;
        }
        return true;
    }
}