import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> colorFreq = new HashMap<>();
        int result[] = new int[queries.length];
        int distinctColors = 0;
        
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (hm.containsKey(ball)) {
                int oldColor = hm.get(ball);
                colorFreq.put(oldColor, colorFreq.get(oldColor) - 1);
                if (colorFreq.get(oldColor) == 0) {
                    colorFreq.remove(oldColor);
                    distinctColors--;
                }
            }

            hm.put(ball, color);
            colorFreq.put(color, colorFreq.getOrDefault(color, 0) + 1);
            if (colorFreq.get(color) == 1) {
                distinctColors++;
            }

            result[i] = distinctColors;
        }
        return result;
    }
}
