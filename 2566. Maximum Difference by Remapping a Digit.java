//SOL 1

class Solution {

    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}

//SOL 2


class Solution {
    private int difference(int num) {
        int firstNonNine = -1, firstDigit = -1;
        int remaining = num;
        while (remaining > 0) {
            int digit = remaining % 10;
            if (digit != 9) {
                firstNonNine = digit;
            }
            firstDigit = digit;
            remaining /= 10;
        }
        
        remaining = num;
        int min = 0, max = 0;
        int multiplier = 1;
        while (remaining > 0) {
            int digit = remaining % 10;
            
            int minDigit = digit;
            int maxDigit = digit;
            
            if (digit == firstDigit) {
                minDigit = 0;
            }

            if (digit == firstNonNine) {
                maxDigit = 9;
            }

            min += multiplier * minDigit;
            max += multiplier * maxDigit;

            multiplier *= 10;    
            remaining /= 10;
        }

        return max - min;
    }

    public int minMaxDifference(int num) {
        return difference(num);
    }
}
