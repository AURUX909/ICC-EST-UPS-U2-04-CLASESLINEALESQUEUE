import Materia.Queue.Queue;
import Materia.Queue.QueueGeneric;
import Materia.Stack.Stack;
import Materia.Stack.StackGeneric;
import Modelos.Screen;

public class App {
    public static void main(String[] args) {
        //runStackExample();
        //runStackGenericExample();
        //runQueueExample();
        runQueueGenericExample();
    }

    public static void runStackExample() {
        Stack stack = new Stack();

        stack.push(5);
        stack.push(7);
        stack.push(10);
        stack.push(20);

        stack.printStack();
        System.out.println("\nSize = " + stack.getSize());

        System.out.println("Top    -> " + stack.peek());
        System.out.println("Pop    -> " + stack.pop());
        System.out.println("Top    -> " + stack.peek());
        System.out.println("Pop    -> " + stack.pop());
        System.out.println("Top    -> " + stack.peek());
    }

    public static void runStackGenericExample() {
        StackGeneric<Screen> screenStack = new StackGeneric<>();
        
        screenStack.push(new Screen(1, "Home Page", "/home"));
        screenStack.push(new Screen(2, "Menu Page", "/home/menu"));
        screenStack.push(new Screen(3, "User Page", "/home/menu/users"));

        System.out.println("Current screen: " + screenStack.peek().getRoute());
        System.out.println("Go back to: " + (screenStack.popNode().getNext().getValue()).getRoute());
        System.out.println("Current screen: " + screenStack.peek().getRoute());

        screenStack.push(new Screen(4, "Setting Page", "/home/menu/setting"));

        System.out.println("Total screens = " + screenStack.getSize());
        System.out.println("Current screen: " + screenStack.peek().getRoute());
        screenStack.printStack();
    }

    public static void runQueueExample() {
        Queue queue = new Queue();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println("Queue size: " + queue.getSize());
        queue.printQueue();
    }

    public static void runQueueGenericExample() {
        QueueGeneric<Screen> screenQueue = new QueueGeneric<>();

        screenQueue.enqueue(new Screen(1, "Computer", "/Home"));
        screenQueue.enqueue(new Screen(2, "Files", "/Home/files"));
        screenQueue.enqueue(new Screen(3, "Documents", "/Home/files/documents"));

        System.out.println(screenQueue.peek());
        //System.out.println(screenQueue.dequeue());

        System.out.println("Current screen: " + screenQueue.peek().getRoute());
        System.out.println("Size = " + screenQueue.getSize());
        screenQueue.printQueue();
    }
}
