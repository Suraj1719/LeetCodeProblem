2933. High-Access Employees
lc: https://leetcode.com/problems/high-access-employees/description/
YT : https://www.youtube.com/watch?v=iF8DjSXC1Bs


Approach : using Map and list

  class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String>ans=new ArrayList<>();
        Map<String,List<Integer>>name_access=new HashMap<>();
        for(List<String>cur:access_times){
            String emp=cur.get(0);
            String time=cur.get(1);

            if(!name_access.containsKey(emp)){
                name_access.put(emp,new ArrayList<>());
            }
            int t=Integer.parseInt(time);
            name_access.get(emp).add(t);
        }

        for(String emp:name_access.keySet()){
            List<Integer>times=name_access.get(emp);
            Collections.sort(times);
            if(highAccess(times)==true){
                ans.add(emp);
            }
        }
    return ans;
    }
    boolean highAccess(List<Integer>time){
        int size=time.size();
        for(int i=2;i<size;i++){
            int cur=time.get(i);
            int prev=time.get(i-2);
            if(Math.abs(cur-prev)<=99)return true;
        }
    return false;
    }
}
