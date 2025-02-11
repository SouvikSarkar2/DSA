class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.toString().contains(part)){
            int start = sb.indexOf(part);
            if (start != -1) {
                 sb.delete(start, start + part.length());
                }
        }
        return sb.toString();
    }
}
