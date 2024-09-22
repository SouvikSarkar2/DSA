//BEATS 75%

class Solution {
    public List<String> validStrings(int n) {
        ArrayList<String> ans = new ArrayList<>();
        findAns(n,0,ans,"0");
        findAns(n,0,ans,"1");
        return ans;
    }

    public static void findAns(int length,int index,ArrayList<String> ans,String accumulator){
        if(index+1==length){
            ans.add(accumulator);
            return;
        }
        char ch =  accumulator.charAt(index);
        if(ch=='0'){
            findAns(length,index+1,ans,accumulator+"1");
        }
        else{
            findAns(length,index+1,ans,accumulator+"0");
            findAns(length,index+1,ans,accumulator+"1");
        }
    }
}


// BEATS 100%



class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        recurr(n,0,ans,s,'1');
        return ans;
    }

    public void recurr(int n, int index, List<String> ans, StringBuilder s,char lastChar) {
        if (index >= n) {
            if (s.length() == n ) {
                ans.add(s.toString());
            }
            return;
        }

        s.append('1');
        recurr(n, index + 1, ans, s,'1');
        s.setLength(s.length() - 1); 
        if(lastChar=='1'){
            s.append('0');
        recurr(n, index + 1, ans, s,'0');
        s.setLength(s.length() - 1); 
        }
    }
  
}
