class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] count = new int[128];

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }

        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int required = t.length();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (count[ch] > 0) {
                required--;
            }

            count[ch]--;

            while (required == 0) {
                int length = right - left + 1;

                if (length < minLength) {
                    minLength = length;
                    start = left;
                }

                char leftChar = s.charAt(left);
                count[leftChar]++;

                if (count[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}
