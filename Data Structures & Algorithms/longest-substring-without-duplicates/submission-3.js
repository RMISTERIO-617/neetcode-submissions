class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s) {
        let res = 0;
        let start = 0;

        const lastIndex = new Map();

        for (let end = 0; end < s.length; end++) {
            const char = s[end];

            if (lastIndex.has(char)) {
                start = Math.max(start, lastIndex.get(char) + 1);
            }

            res = Math.max(res, end - start + 1);

            lastIndex.set(char, end);
        }

        return res;
    }
}
