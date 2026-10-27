class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Arrancamos el motor empezando a acomodar desde la silla 0
        backtrack(result, nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, int [] nums, int indiceActual){
        if(indiceActual == nums.length){
            List<Integer> permutacionActual = new ArrayList<>();
            for( int num : nums){
                permutacionActual.add(num);
            }
            result.add(permutacionActual);
            return;
        }
        for(int i = indiceActual; i < nums.length; i++){
            swap(nums, indiceActual,i);
            backtrack(result, nums, indiceActual + 1);
            swap(nums,indiceActual, i);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
