//BEATS 100% BAWAL

class Solution {
    public int minOperations(int n) {
       int a = n%2==0 ? 1 : 2;
       return (n/2)*(a+(n/2)-1);
    }
}

//BEATS 50% 
class Solution {
    public int minOperations(int n) {
        int sum = 0 ;
        int ans = 0;
        for(int i = 0 ; i<=(n/2)-1 ; i++){
            if(sum==0){
                if(n%2==0){
                    sum+=1;
                    ans+=sum;
                    continue;
                }
                else{
                    sum+=2;
                    ans+=sum;
                    continue;
                }
            }
            sum+=2;
            ans+=sum;
        }
        return ans;
    }
}


