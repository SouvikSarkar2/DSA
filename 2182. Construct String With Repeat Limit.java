class Solution {

    class CharIntPair {
    Character ch;
    Integer val;

    CharIntPair(Character ch, Integer val) {
        this.ch = ch;
        this.val = val;
    }

    public Character getChar() {
        return ch;
    }

    public Integer getVal() {
        return val;
    }
}


    public String repeatLimitedString(String s, int repeatLimit) {

        Comparator<CharIntPair> cmp = (a, b) -> b.getChar().compareTo(a.getChar());
        PriorityQueue<CharIntPair> pq = new PriorityQueue<>(cmp);
         
         int freq[] = new int[26];
         for(int i = 0 ; i < s.length() ; i++){
            freq[s.charAt(i)-'a']++;
         }
         for(int i = 25 ; i>=0 ; i--){
            if(freq[i]>0){
                pq.offer(new CharIntPair((char)(i+'a'),freq[i]));
            }
         }

        StringBuilder ans = new StringBuilder("");

        while(!pq.isEmpty()){
            CharIntPair curr = pq.poll();
            if(curr.getVal()<=repeatLimit){
                int limit = curr.getVal();
                while(limit>0){
                    ans.append(curr.getChar());
                    limit--;
                }
            }
            else{
                 int limit = repeatLimit;
                while(limit>0){
                    ans.append(curr.getChar());
                    limit--;
                }
                if(pq.isEmpty()){
                    return ans.toString();
                }
                CharIntPair next = pq.poll();
                ans.append(next.getChar());
                if(next.getVal()!=1){
                    pq.offer(new CharIntPair(next.getChar(),next.getVal()-1));
                }
                 pq.offer(new CharIntPair(curr.getChar(),curr.getVal()-repeatLimit));
            }
        }

         return ans.toString();   
          }
}
