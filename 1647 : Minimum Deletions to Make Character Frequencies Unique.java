// see explanation : yt video : https://youtu.be/7AcSHzBcQKs

class Solution {
    public int minDeletions(String s) {
        int frq[]=new int[26];
        int n=s.length();
        //store the frq. of each cha.
        for(int i=0;i<n;i++){
            frq[s.charAt(i)-'a']++;
        }

        Map<Integer,Integer>set=new HashMap<>();
        int total_deleted_char=0;
        for(int i=0;i<26;i++){
            set.put(frq[i],set.getOrDefault(frq[i],0)+1);
        }
        
        for(int i=0;i<26;i++){

            if(frq[i]!=0){

                if(set.containsKey(frq[i]) && set.get(frq[i])>1){
                    
                   int temp=frq[i];
                   
                   while(set.containsKey(temp)){
                       total_deleted_char++;
                       temp--;
                       if(temp==0)break;
                    }
                    
                set.put(frq[i],set.getOrDefault(frq[i],0)-1);

                if(set.get(frq[i])==0)
                   set.remove(frq[i]);

                if(temp!=0)
                set.put(temp,set.getOrDefault(temp,0)+1);
                }
            }
        }
        
    return total_deleted_char;
    }
}
