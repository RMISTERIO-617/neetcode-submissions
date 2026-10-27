class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // PASO 1: Ordenar para agrupar los duplicados (ej. [1, 2, 1] se vuelve [1, 1, 2])
        Arrays.sort(nums);
        
        // Arrancamos el motor (sin arreglo de booleanos, solo con el índice 0)
        backtrack(result, new ArrayList<>(), nums, 0);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combinacionActual, int[] nums, int indiceActual) {
        
        // CASO BASE DE SUBCONJUNTOS: ¡Todo es válido! 
        // No esperamos a llegar al final del arreglo. Cada paso que damos es un subconjunto válido (incluyendo la lista vacía al inicio).
        result.add(new ArrayList<>(combinacionActual));

        // CICLO DE EXPLORACIÓN: Avanzamos siempre hacia la derecha desde indiceActual
        for (int i = indiceActual; i < nums.length; i++) {
            
            // REGLA ANTICLONACIÓN: 
            // Si no es el primer número de ESTA iteración (i > indiceActual) 
            // y es exactamente igual al de atrás (nums[i] == nums[i-1]), nos lo saltamos.
            if (i > indiceActual && nums[i] == nums[i - 1]) {
                continue;
            }

            // PASO 1 (Avanzar)
            combinacionActual.add(nums[i]);
            
            // PASO 2 (Explorar): Mandamos 'i + 1' para seguir avanzando en el arreglo
            backtrack(result, combinacionActual, nums, i + 1);
            
            // PASO 3 (Retroceder)
            combinacionActual.remove(combinacionActual.size() - 1);
        }
    }
}