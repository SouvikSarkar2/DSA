//APPROACH 1 -- 0ms

class Solution {
    public boolean isPowerOfTwo(int n) {
       if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        return isPowerOfTwo(n / 2);
        
    }
}


//APPROACH 2 -- 0ms

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}


//MY APPROACH -- 1ms

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        return Math.abs(Math.log(n) / Math.log(2) - Math.floor(Math.log(n) / Math.log(2))) < 1E-10;
    }
}
