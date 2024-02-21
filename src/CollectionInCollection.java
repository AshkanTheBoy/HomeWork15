import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class CollectionInCollection {
    public static void main(String[] args) {
        ArrayList<Stack<String>> listOfStacks = new ArrayList<>();
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        stack1.add("1");
        stack1.add("12");
        stack1.add("123");
        stack1.add("1234");

        stack2.add("4321");
        stack2.add("321");
        stack2.add("21");
        stack2.add("1");

        listOfStacks.add(stack1);
        listOfStacks.add(stack2);

        for (Stack<String> stack: listOfStacks){

            int count = 0;
            System.out.println();
            System.out.println(stack);
            while(!stack.isEmpty()){
                System.out.println("ELEMENT "+count+":");
                System.out.println(stack.pop());
                count++;
            }
        }

        System.out.println();
        Random random = new Random();
        int count = 0;
        for (Stack<String> stack: listOfStacks){
            int k;
            for (int i = 0; i < 10; i+=k) {
                stack.add(String.valueOf(i));
                k = random.nextInt(6)+1;
            }
            System.out.println("STACK "+count++);
            System.out.println(stack);
        }

        System.out.println();
        System.out.println(listOfStacks);
        listOfStacks.remove(1);
        System.out.println(listOfStacks);
        listOfStacks.add(new Stack<>());
        listOfStacks.get(1).add("ANONYMOUS STACK STRING");
        System.out.println(listOfStacks);

    }
}
