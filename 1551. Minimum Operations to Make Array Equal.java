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

//BEATS 100%

class Solution {
    public int minOperations(int n) {
        int mid =-1, idx=0, res=0;
        if((n & 1)== 1){
            // Finding mid index
            idx=n/2;
            // finding mid value
            mid = (2*idx)+1;
         }else{
            // Finding mid index
            idx = (n/2)-1;
             // finding mid value
            mid = (2*idx)+2;
            res+=1;
        }
        /* Finding the required sum till mid of an array 
         for n=5
         Ex : 1,3,5,7,9
         mid = 5 
         req = all the elements before 5 should also be equal to 5 
         hence sum of all till mid is req = 10;

         sum is actual sum of all the element till mid(5) that is sum = 4

         req-sum : gives me the remaining quantity required to make all 5.

        */
        int req= mid*(idx);
        int sum = (int)(((double)idx/2)*(double)(1+ (2*(idx-1)+1)));
        return res+(req-sum);
    }
}
