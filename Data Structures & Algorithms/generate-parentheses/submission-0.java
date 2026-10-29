class Solution {
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(),0,0,n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder combinacionActual, int abiertos, int cerrados, int max) {
        
       if(combinacionActual.length() == max * 2){
        result.add(combinacionActual.toString());
        return;
       }

       if(abiertos < max){
        combinacionActual.append("(");
        backtrack(result, combinacionActual, abiertos + 1, cerrados, max);
        combinacionActual.deleteCharAt(combinacionActual.length() - 1);
       }
       if(cerrados < abiertos){
            combinacionActual.append(")");
            backtrack(result, combinacionActual, abiertos, cerrados + 1, max);
            combinacionActual.deleteCharAt((combinacionActual.length() - 1));
       }
    }
}
