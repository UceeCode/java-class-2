import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();

        stack.push(12L);
        System.out.println("Pushed 12L");
        printStack(stack);

        stack.push(34567);
        printStack(stack);

        stack.push(1.0F);
        System.out.println("Pushed 1.0F");
        printStack(stack);

        stack.push(1234.5678);
        System.out.println("Pushed 1234.5678");
        printStack(stack);

        // Remove items from stack
        try {
            Number removedObject = null;
            // Pop elements from stack
            while (true) {
                removedObject = stack.pop();
                System.out.printf("Popped %s\n", removedObject);
                printStack(stack);
            }
        } catch (EmptyStackException emptyStackException) {
            emptyStackException.printStackTrace();
        }

    }

    // Display stack contents
    private static void printStack(Stack<Number> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty\n");
        } else {
            System.out.print("Stack contains: ");
            for (int i = stack.size() - 1; i >= 0; i--) {
                System.out.print(stack.get(i) + " ");
            }
            System.out.println("(top)");
        }
    }
}

