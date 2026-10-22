class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k<=0){
            return new int[0];
        }
        int n = nums.length;
       
        int[] resultado = new int[n - k +1];
        int resIndex = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
        
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {          
                deque.pollLast();
            }
            deque.offerLast(i);

            if(i >= k - 1){
                resultado[resIndex++] = nums[deque.peekFirst()];
            }
        }
    return resultado;
    }
}

