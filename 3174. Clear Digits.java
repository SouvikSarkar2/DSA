//BEATS 100%

class Solution {
    public String clearDigits(String s)
    {
        int len = s.length();
        StringBuilder str = new StringBuilder ();
        int i=-1;

        for(int j=0;j<len;j++)
        {
            char c = s.charAt(j);
            if(c>='a' && c<='z')
            {
                i++;
                str.append(c);
            }
                
            else{
                if(i>=0)
                {
                    str.deleteCharAt(i);
                    i--;
                }
            }
        }

        return str.toString();
    }
}


//BEATS 10%

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int numCount = 0 ;
        for(int i = 0 ; i<s.length() ; i++){
           char c = s.charAt(i);
           if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
           }
           else{
            stack.push(c);
           }

        }
        StringBuilder sb = new StringBuilder();
        System.out.println(stack);
        int size = stack.size();
        for(int i = 0 ; i<size ; i++){
           char c = stack.pop();
            
            sb.append(c);
        } 

        return sb.reverse().toString();

        
    }
}
