class Solution {
    public int maxDiff(int num) {
        String st = Integer.toString(num); 
        
        // Find the first digit that is not '9' for max
        char replaceForMax = ' ';
        for (char ch : st.toCharArray()) {
            if (ch != '9') {
                replaceForMax = ch;
                break;
            }
        }
        String max = (replaceForMax == ' ') ? st : st.replace(replaceForMax, '9');

        // For min: if first digit is not '1', we replace it with '1'
        // else, we look for the first digit (not at index 0) that is not '0' or '1' and replace it with '0'
        char replaceForMin = ' ';
        if (st.charAt(0) != '1') {
            replaceForMin = st.charAt(0);
            st = st.replace(replaceForMin, '1');
        } else {
            for (int i = 1; i < st.length(); i++) {
                char ch = st.charAt(i);
                if (ch != '0' && ch != '1') {
                    replaceForMin = ch;
                    break;
                }
            }
            if (replaceForMin != ' ') {
                st = st.replace(replaceForMin, '0');
            }
        }

        String min = st;

        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}
