class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        let valuesalreadyseen = [];
        for (let i=0;i<nums.length;i++){
            let value =nums[i];
            if (valuesalreadyseen.indexOf(value) !== -1){
                return true
            }
            valuesalreadyseen.push(value);
        }
            return false

    }
}
