package p1;

public class GenericStackTest {
    public static void main(String[] args) {
        GenericStack<Integer> integerGenericStack = new GenericStack<>();
        GenericStack<String> stringGenericStack= new GenericStack<>(3);

        integerGenericStack.push(2);
        System.out.println(integerGenericStack.pop());
        System.out.println(integerGenericStack.isEmpty());
        System.out.println(integerGenericStack);

        stringGenericStack.push("str1");
        stringGenericStack.push("str2");
        stringGenericStack.push("str3");
        stringGenericStack.push("str4");
        System.out.println(stringGenericStack.peek());
        System.out.println(stringGenericStack.getSize());
        System.out.println(stringGenericStack);
    }
}
