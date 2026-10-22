class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k<=0){
            return new int[0];
        }
        int n = nums.length;
        int[] resultado = new int[n - k + 1];
        int resIndex = 0;

        int[] deque = new int[n];
        int head = 0;
        int tail = 0;

        for (int i = 0; i < n; i++) {
            if(head < tail && deque[head] < i - k + 1){
                head++;
            }
        
            while (head < tail && nums[deque[tail - 1]] < nums[i]) {          
                tail--;
            }
            deque[tail++] =i;

            if(i >= k - 1){
                resultado[resIndex++] = nums[deque[head]];
            }
        }
    return resultado;
    }
}

