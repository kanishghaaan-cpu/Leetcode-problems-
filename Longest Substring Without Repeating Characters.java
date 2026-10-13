import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(s.charAt(i));

            int length = i - start + 1;

            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }
}
