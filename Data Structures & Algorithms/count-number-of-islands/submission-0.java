class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numeroDeIslas = 0;

        // 1. El escaneo: Recorremos todo el mapa
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Si encontramos tierra ('1')...
                if (grid[i][j] == '1') {
                    numeroDeIslas++;         // Contamos la isla
                    hundirIsla(grid, i, j);  // Lanzamos la función para hundirla
                }
            }
        }

        return numeroDeIslas;
    }

    // Método auxiliar para explorar y hundir (DFS)
    private void hundirIsla(char[][] grid, int i, int j) {
        // 2. Los límites: Si salimos del mapa o caemos en agua ('0'), nos detenemos
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Hundimos este pedazo de tierra convirtiéndolo en agua
        grid[i][j] = '0';

        // 3. La expansión: Exploramos en las 4 direcciones
        hundirIsla(grid, i + 1, j); // Abajo
        hundirIsla(grid, i - 1, j); // Arriba
        hundirIsla(grid, i, j + 1); // Derecha
        hundirIsla(grid, i, j - 1); // Izquierda
    }
}