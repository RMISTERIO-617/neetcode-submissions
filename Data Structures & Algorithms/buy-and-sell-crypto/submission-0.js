class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices) {
        let minofprices=prices[0];
        let res =0;
        for (let i =1; i < prices.length; i++){
            minofprices= Math.min(minofprices, prices[i]);
            res = Math.max(res,prices[i] - minofprices);

        }
    return res;


    }
}
