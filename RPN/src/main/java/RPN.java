    import java.io.BufferedReader ;
    import java.io.IOException ;
    import java.io.InputStreamReader ;
    import java.util.Stack ;

public class RPN {
/*
    A very basic calculator which uses stack to push and pop numbers from bufferedReader, 
    if operand is found then last two numbers are popped and result is pushed back to stack.
    */

  
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack(); //needed double for division
        while (true) {
            String line = reader.readLine();
            String[] symbols = line.split(" "); // adds multiple values i.e 20 30 +
            for (String symbol : symbols) {  // runs a loop for all symbols in array
                switch (symbol) {
                    case "+":
                        System.out.println("add operation");
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        System.out.println("subtract operation");
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        System.out.println("multiplication operation");
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        System.out.println("division operation");
                        double divElement = stack.pop();
                        stack.push(stack.pop() / divElement);
                        break;
                    case "exit":
                        System.exit(1);
                    default:
                        System.out.println("Added to stack: " +symbol);
                        stack.push(Double.parseDouble(symbol)); // if not one of the other cases, it is assumed that it's a number
                        break;
                }
                System.out.println("stack content: " +stack);
            }
        }
    }
}
