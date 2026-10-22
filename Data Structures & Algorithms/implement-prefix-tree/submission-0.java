class PrefixTree {
    // Cada nodo tiene un arreglo de 26 "caminos" posibles (uno para cada letra del abecedario)
    private PrefixTree[] children;
    
    // Esta bandera nos avisa si aquí termina una palabra, o si solo es un nodo de paso
    private boolean isEnd;

    // Constructor: Cuando creas un nodo, le preparas sus 26 espacios vacíos
    public PrefixTree() {
         children = new PrefixTree[26];
    }

    // MÉTODO 1: METER UNA PALABRA AL DICCIONARIO
    public void insert(String word) {
        PrefixTree node = this; // Empezamos en la raíz del árbol
        
        for (char c : word.toCharArray()) {
            int idx = c - 'a'; // Convertimos la letra a un índice del 0 al 25
            
            // Si no existe un camino para esta letra, construimos un nuevo nodo
            if(node.children[idx] == null){
                node.children[idx] = new PrefixTree();
            }
            // Brincamos al nodo de esa letra para seguir construyendo hacia abajo
            node = node.children[idx];
        }
        // Al terminar el ciclo, marcamos el último nodo para decir: "Aquí acaba una palabra válida"
        node.isEnd = true;
    }

    // MÉTODO 2: BUSCAR SI UNA PALABRA EXACTA EXISTE
    public boolean search(String word) {
        PrefixTree node = searchPrefix(word);
        // Debe existir el camino (node != null) Y ADEMÁS debe ser final de palabra
        return node != null && node.isEnd;
    }

    // MÉTODO 3: BUSCAR SI ALGUNA PALABRA EMPIEZA CON ESTE PREFIJO
    public boolean startsWith(String prefix) {
        PrefixTree node = searchPrefix(prefix);
        // Aquí no importa si es final de palabra, solo nos importa que el camino no se haya roto
        return node != null;
    }

    // FUNCIÓN AYUDANTE: Recorre el árbol letra por letra. La usan search y startsWith.
    private PrefixTree searchPrefix(String s) {
        PrefixTree node = this;
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            // Si en algún punto el camino se rompe (es null), el prefijo/palabra no existe
            if(node.children[idx] == null){
                return null;
            }
            // Si sí existe, avanzamos al siguiente nodo
            node = node.children[idx];
        }
        // Si el ciclo terminó sin romperse, devolvemos el último nodo al que llegamos
        return node;
    }
}