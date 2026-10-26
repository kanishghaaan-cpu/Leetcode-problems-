class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0;

        for (int money : nums) {
            int c = Math.max(b, a + money);
            a = b;
            b = c;
        }

        return b;
    }
}
