class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices) {
        let n = prices.length;
        let res = 0;

        // Explore all possible ways to buy and sell stock
        for (let i = 0; i < n - 1; i++) {
            for (let j = i + 1; j < n; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;


    }
}
