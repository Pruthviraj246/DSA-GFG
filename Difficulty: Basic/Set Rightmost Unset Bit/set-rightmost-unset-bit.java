class Solution {
    public int setBit(int n) {
        for (int j = 0; j < 31; j++) {
            if ((n & (1L << j)) == 0) {
                n |= (1L << j);
                break;
            }
        }
        return n;
    }
}