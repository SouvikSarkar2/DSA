class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> output = new ArrayList<>(); 
        HashMap<String, Integer> map = new HashMap<>();
        String s1Str[] = s1.split(" ");
        
        for(String word: s1Str) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String s2Str[] = s2.split(" ");
         // Count occurrences of words from the second sentence
        for (String word : s2Str) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Add words that appear only once to the output list
        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                output.add(word);
            }
        }

        // covert list to a string array
        return output.toArray(new String[0]);
        
    }
}
