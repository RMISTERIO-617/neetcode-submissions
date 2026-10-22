class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();


        for (int i=0; i < tokens.length; i++){
            String token = tokens[i];
            
            //We see for every case and value every 2 values which it can be continous after eevry result
            //we are going to use a switch state for every type of equation
            switch(token){
                case "+":{
                    stack.push(stack.pop() + stack.pop());
                    break;}
                case "*":{
                    stack.push(stack.pop() * stack.pop());
                    break;}
                case "-":{
                    // performing rest it matters who goes where
                    int x = stack.pop();
                    int y = stack.pop();
                    //push result to the stack
                    stack.push(y - x);
                    break;}
                case "/":{
                // doing divide it matters who goes where
                    int x = stack.pop();
                    int y = stack.pop();
                    //push result to the stack
                    stack.push(y / x);
                    break;}
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }          
        }
        //We convert the result string to int
        return stack.pop();  
    }
}
