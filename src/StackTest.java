public class StackTest {
    public static void main(String[] args) {
        Stack<Element> stack= new Stack<Element>();
        for (int i = 0; i < 50; i++) {
            stack.push(new Element(i));
            System.out.println(stack.toString());
        }


        for (int i = 0; i < 50; i++) {
            try {
                stack.pop().getNumber();

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(stack.toString());
        }

    }
}
