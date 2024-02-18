//100% beats solution

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        int f = 0;
        int b = 0;
        char box[] = boxes.toCharArray();
        for (int i = 0; i < n; i++) {
            if (box[i] == '1') {
                f++;
                ans[0] += i;
            }
        }
        if (box[0] == '1') {
            f--;
            b++;

        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1] - f + b;
            if (box[i] == '1') {
                f--;
                b++;
            }
        }
        return ans;
    }
}


//MY 30% Beats Soulution

class Solution {
    public int[] minOperations(String boxes) {
        int ans[]=new int[boxes.length()];
        for(int i = 0 ; i<boxes.length() ; i++){
            ans[i]=findDis(boxes,i);
        }
        return ans;
    }

    public int findDis(String boxes,int k){
        int res = 0 ;
    for(int i = 0 ; i<boxes.length() ; i++){
        if(i==k){
            continue;
        }
        if(boxes.charAt(i)=='1'){

            res+=Math.abs(i-k);
        }
        
    }

    return res;
    }
}
