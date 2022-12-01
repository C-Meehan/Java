import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello %s, how are you today?", name);
    }

    // public String guestGreeting(String name, String dayPeriod) {
    //     // YOUR CODE HERE
    //     return String.format("Good %s, %s, lovely to see you.", dayPeriod, name);
    // } 
    
    public String guestGreeting() {
        // YOUR CODE HERE
        // Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        // System.out.println(date.getHours());
        // System.out.println(calendar.get(calendar.HOUR_OF_DAY));
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        if (hour < 12) {
            return ("Good morning, lovely to see you.");
        }
        else if (hour >= 12 && hour < 18) {
            return ("Good afternoon, lovely to see you.");
        }
        else {
            return ("Good evening, lovely to see you.");
        }
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date;
    }
    
    // public String respondBeforeAlexis(String conversation, int phrase) {
    //     // YOUR CODE HERE
    //     switch(phrase){
    //     case 1:
    //         return String.format("%s Nevermind alexa I can do it!", conversation);
    //     case 2:
    //         return String.format("%s Your toy is where you left it last", conversation);
    //     case 3:
    //         return String.format("%s Sounds like Batman likes to fail.", conversation);
    //     default:
    //         return String.format("Irrelevant stuff");
    //     }

    public String respondBeforeAlexis(String conversation){
        if (conversation.indexOf("Alexis") > -1) {
            return ("Right Away, sir. She certainly isn't sophisticated enough for that.");
        }
        else if (conversation.indexOf("Alfred") > -1) {
            return ("At your service. As you wish, naturally.");
        }
        else {
            return ("Right. And with that I shall retire.");
        }
    }
}
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!


