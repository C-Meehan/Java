public class Test {
    public static void main(String[] args){

        // Print the capitals of Brazil and Croatia
        // Print the countries where Vienna and Abu Dhabi are the capitals
        // You will need to create an instance of 'Capitals'

        // Your code here
        Capitals test = new Capitals();
        test.getCapital("Brazil");
        // System.out.println("Vienna is the capital of which country?");
        System.out.println(test.getCountry("Vienna"));
        test.getCapital("Croatia");
        // System.out.println("Abu Dhabi is the capital of which country?");
        System.out.println(test.getCountry("Abu Dhabi"));

        // This should be your output
        /*
        What is the capital of Brazil?
        The capital of Brazil is Brasilia.
        Vienna is the capital of which country?
        Vienna is the capital of Austria.
        What is the capital of Croatia?
        I don't know the capital of Croatia.
        Abu Dhabi is the capital of which country?
        I don't know that city.
        */
    }
}