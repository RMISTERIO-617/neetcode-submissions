class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int filas= matrix.length;
        int columnas = matrix[0].length;

        int izq=0;
        int der = (filas * columnas) -1;


        while ( izq <= der){
            int mid = izq + (der - izq) / 2;

            int valorMedio =matrix[mid/columnas][mid % columnas];

            if(valorMedio == target){
                return true;
            } else if (valorMedio < target){
                izq = mid +1;
            } else{
                der = mid - 1;
            }
        }
        return false;
    }
}

