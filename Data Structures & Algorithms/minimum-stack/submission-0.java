class MinStack {
    // 1. Declarar las variables a nivel de clase para que todos los métodos las vean
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        // 2. Inicializarlas dentro del constructor
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        //2.- Calculamos el minimo que tiene hasta este punto exacto y lo apilamos
        int currentMin = minStack.isEmpty() ? val : Math.min(val, minStack.peek());
        minStack.push(currentMin);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
