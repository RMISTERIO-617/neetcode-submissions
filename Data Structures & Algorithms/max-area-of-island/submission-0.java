class Solution {
    // FUNCIÓN AYUDANTE 1: El radar. Revisa si la coordenada existe y si es tierra (1).
    public boolean isSafe(int[][] grid, int r, int c, int rows, int cols){
        // Retorna true solo si no nos salimos del mapa Y la celda actual vale 1.
        return r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1;
    }

    // FUNCIÓN AYUDANTE 2: El expansor (Búsqueda en Anchura / BFS).
    public int BFS(int[][] grid, int r, int c, int rows, int cols){
        // SOLO 4 DIRECCIONES: Arriba, Abajo, Izquierda, Derecha (adiós a las diagonales)
        int[] dr = {-1, 1, 0, 0}; 
        int[] dc = { 0, 0, -1, 1}; 
        
        int area = 0; // Contador de cuánta tierra encontramos en esta isla

        // La cola (Queue) es la fila de espera de los pedazos de tierra que tenemos que revisar
        Queue<int[]> q = new LinkedList<>();

        // Metemos la coordenada inicial a la fila de espera
        q.offer(new int[]{r, c});
        
        // ¡SÚPER IMPORTANTE!: Hundimos este pedazo de tierra (lo volvemos 0) para no volver a contarlo
        grid[r][c] = 0;

        // Mientras haya pedazos de tierra en la fila de espera...
        while (!q.isEmpty()){
            // Sacamos al primer elemento de la fila
            int[] curr = q.poll();
            
            // Sumamos 1 al área porque acabamos de procesar un pedazo de tierra válido
            area++;
            
            // Revisamos a los 4 vecinos de este pedazo de tierra
            for(int i = 0; i < 4; i++){
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                
                // Si el vecino es tierra válida (el radar dice true)...
                if (isSafe(grid, nr, nc, rows, cols)){
                    // Lo hundimos inmediatamente para que no lo metan a la fila de espera 2 veces
                    grid[nr][nc] = 0;
                    // Lo formamos en la fila de espera para luego revisar a SUS propios vecinos
                    q.offer(new int[]{ nr, nc });
                }
            }
        }
        // Al vaciarse la fila, devolvemos el tamaño total de la isla
        return area;
    }

    // FUNCIÓN PRINCIPAL
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0; // Aquí guardaremos el récord de la isla más grande
        
        // Escaneamos el mapa completo, celda por celda
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                // Si chocamos con tierra virgen...
                if(grid[r][c] == 1){
                    // Disparamos el BFS para que mida la isla completa
                    int area = BFS(grid, r, c, rows, cols);
                    
                    // Actualizamos el récord si esta isla fue más grande que las anteriores
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
}
