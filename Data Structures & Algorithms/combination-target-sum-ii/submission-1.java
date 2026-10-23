class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> combinacionActual, int[] candidates, int targetRestante, int indiceActual) {
        if(targetRestante == 0){
            result.add(new ArrayList<>(combinacionActual));
            return;
        }

        if(targetRestante < 0 || indiceActual >= candidates.length){
            return;
        }

        for (int i = indiceActual; i < candidates.length; i ++){
            if(i > indiceActual && candidates[i] == candidates[i-1]){
                continue;
            }
            combinacionActual.add(candidates[i]);
            backtrack(result, combinacionActual, candidates, targetRestante - candidates[i],i + 1);

            combinacionActual.remove(combinacionActual.size()-1);

        }

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        // Befre calling the backtrackimg we sort the numbers or candidates from lower to higher
        Arrays.sort(candidates);
        backtrack(res,new ArrayList<>(),candidates, target, 0);

        return res;
    }
}

