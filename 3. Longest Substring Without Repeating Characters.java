class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue <Character> q = new LinkedList<>();
        int max=0;
        for(int i = 0 ; i<s.length() ; i++){
            if(q.contains(s.charAt(i))){
                while(q.peek()!=s.charAt(i)){
                    q.remove();
                }
                q.remove();
            q.add(s.charAt(i));
            max=Math.max(max,q.size());
            }
            else{
                q.add(s.charAt(i));
            max=Math.max(max,q.size());
            }
        }
        return max;
    }
}
