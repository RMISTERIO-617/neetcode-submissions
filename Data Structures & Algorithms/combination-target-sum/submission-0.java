class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> combinacionActual, int[] nums, int targetRestante, int indiceActual) {
        if(targetRestante == 0){
            result.add(new ArrayList<>(combinacionActual));
            return;
        }

        if(targetRestante < 0 || indiceActual >= nums.length){
            return;
        }

        for (int i = indiceActual; i < nums.length; i ++){
            combinacionActual.add(nums[i]);
            backtrack(result,combinacionActual, nums, targetRestante - nums[i], i);

            combinacionActual.remove(combinacionActual.size()-1);

        }

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums, target, 0);

        return res;
    }
}
