public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

// Methods from trace practice
public final class Main {
    
    public static void main(String[] args){
        // Print "Hello Sam, how are you today?" and "Hello Rick Jones, how are you today?"
        // String name = "Sam";
        // Your code here
        // System.out.println(name);
        // greeting();
        String name = "Sam";
        String firstName = "Rick";
        String lastName = "Jones";
        // System.out.println(greeting2(name));
        System.out.println(greeting(firstName, lastName));
    }

    // Don't worry about the 'public' and 'static' keywords for now.
    // We will discuss them later.
    public static void greeting(){
        String name = "Sam";
        System.out.println(String.format("Hello %s, how are you today?", name));
    }

    public static String greeting2(String name){
        return String.format("Hello %s, how are you today?", name);
    }

    public static String greeting(String firstName, String lastName){
        return String.format("Hello %s %s, how are you today?", firstName, lastName);
    }

}