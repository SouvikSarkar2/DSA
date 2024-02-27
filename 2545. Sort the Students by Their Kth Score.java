class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, Comparator.comparingDouble((int[] a) -> a[k]).reversed());

        return score;
    }
}
