class Solution {
    public int pivotInteger(int n) {
        double result = Math.sqrt(((n * n) + n) / 2);
        return (result == (int) result) ? (int) result : -1;
    }
}
