class Solution {
  /**
   * @param {number[]} nums
   * @param {number} k
   * @return {number[]}
   */
  topKFrequent(nums, k) {
    const frequencyMap = {};

    for (let num of nums) {
      frequencyMap[num] = (frequencyMap[num] || 0) + 1;
    }

    const sorted = Object.keys(frequencyMap).sort((a, b) => 
      frequencyMap[b] - frequencyMap[a]
    );

    return sorted.slice(0, k).map(Number);
  }
}
