class Solution {
    // FUNCIÓN AYUDANTE: El motor de exploración (Backtracking)
    private void backtrack(List<List<Integer>> result, List<Integer> combinacionActual, int[] candidates, int targetRestante, int indiceActual) {
        
        // CASO BASE 1 (Éxito): Si la resta llega exactamente a 0, encontramos una combinación válida.
        if(targetRestante == 0){
            // Hacemos una copia nueva de la lista actual y la guardamos en nuestra lista maestra.
            result.add(new ArrayList<>(combinacionActual));
            return;
        }

        // CASO BASE 2 (Fracaso): Si la resta se vuelve negativa (nos pasamos) o ya no hay más números en el arreglo, cortamos esta rama.
        if(targetRestante < 0 || indiceActual >= candidates.length){
            return;
        }

        // CICLO DE EXPLORACIÓN: Empezamos a probar números desde la posición donde nos quedamos (indiceActual)
        for (int i = indiceActual; i < candidates.length; i ++){
            
            // REGLA 1 (Sin duplicados): Si este número es igual al anterior Y no es el primero de esta iteración...
            // Lo saltamos con 'continue' para evitar generar resultados gemelos idénticos.
            if(i > indiceActual && candidates[i] == candidates[i-1]){
                continue;
            }
            
            // PASO 1 (Avanzar): Agregamos el número actual a nuestra lista temporal.
            combinacionActual.add(candidates[i]);
            
            // PASO 2 (Explorar): Llamamos de nuevo a la recursividad.
            // Al target restante le restamos el número actual.
            // REGLA 2 (Máximo una vez): Le pasamos 'i + 1' para obligar al algoritmo a usar el SIGUIENTE número en la próxima vuelta.
            backtrack(result, combinacionActual, candidates, targetRestante - candidates[i], i + 1);

            // PASO 3 (Retroceder): Sacamos el último número que metimos para dejar la lista limpia y que el ciclo pruebe la siguiente opción.
            combinacionActual.remove(combinacionActual.size()-1);
        }
    }

    // FUNCIÓN PRINCIPAL
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        // PASO PREVIO CRUCIAL: Ordenar el arreglo de menor a mayor.
        // Si no hacemos esto, la regla de candidates[i] == candidates[i-1] no sirve para detectar los duplicados.
        Arrays.sort(candidates);
        
        // Arrancamos el motor de backtracking con una lista temporal vacía y empezando desde el índice 0.
        backtrack(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }
}

