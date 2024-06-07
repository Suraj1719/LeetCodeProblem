class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        // //brute force
        // String word[]=sentence.split(" ");
        // for(String s:dictionary){
        //     for(int i=0;i<word.length;i++){
        //         if(s.length()<word[i].length() && 
        //             s.equals(word[i].substring(0,s.length()))){
        //                 word[i]=s;
        //             }
        //     }
        // }
        // String ans = String.join(" ", word);
        // return ans;

        //Approach 2: Hash Set
         String[] wordArray = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);

        // Replace each word in sentence with the corresponding shortest root
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = shortestRoot(wordArray[i], dictSet);
        }

        return String.join(" ", wordArray);


        //Approach 3: Prefix Trie
    }

    private String shortestRoot(String word, Set<String> dictSet) {
        // Find the shortest root of the word in the dictionary
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dictSet.contains(root)) {
                return root;
            }
        }
        // There is not a corresponding root in the dictionary
        return word;
    }
}