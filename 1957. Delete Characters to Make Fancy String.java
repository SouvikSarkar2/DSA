//BEATS 40%

class Solution {
    public String makeFancyString(String s) {
        if(s.length()<3){
            return s;
        }
        StringBuilder ans = new StringBuilder("");
        ans.append(s.charAt(0));
        for(int i = 1 ; i<s.length()-1 ; i++){
            if(s.charAt(i)==s.charAt(i-1) && s.charAt(i)==s.charAt(i+1)){
                 continue;
            }
            ans.append(s.charAt(i));
        }
        ans.append(s.charAt(s.length()-1));
        return ans.toString();
    }
}

//BEATS 100%

class Solution {
    public String makeFancyString(String s) {
        int sameCount = 0;
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        for (char cur : s.toCharArray()) {
            if (cur == prev) {
                sameCount++;
            }
            else {
                sameCount = 1;
            }
            if (sameCount < 3) sb.append(cur);
            prev = cur;
        }
        return sb.toString();
    }
}
