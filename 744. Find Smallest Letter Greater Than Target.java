Brute force :

time :O(n)   space:O(1)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        for(int i=0;i<letters.length;i++){
            char ch=letters[i];
            if(ch>target)
            return ch;
        }
    return letters[0];
    }
}

Binary search (optimised):

time :O(log n)  spacce:O(1)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0;int r=letters.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(letters[mid]<=target)
                l=mid+1;
            else
                r=mid-1;
        }
        return letters[l%letters.length];
    }
}
