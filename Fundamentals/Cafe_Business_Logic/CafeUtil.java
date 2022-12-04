import java.util.ArrayList;
public class CafeUtil {
    
    public String getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        // System.out.println(sum);
        }
        // return sum;
        return String.format("Purchases needed by week %s: %s", numWeeks, sum);
    }

    public double getOrderTotal(double[] lineItems) {
        // double[] lineItems = new double[4];
        double total = 0;
        for (int i = 0; i < lineItems.length; i++) {
            total += lineItems[i];
        }
        return total;
    }

    public ArrayList<String> displayMenu(ArrayList<String> menu) {
        for (int i = 0; i < menu.size(); i++) {
            // System.out.println(menu.get(i));
            // String name = menu.get(i);
            System.out.printf("%s %s\n", i, menu.get(i));
        }
        // String name = menu.get(0);
        return menu;
    }

    public ArrayList<String> addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println(String.format("Hello, %s!", userName));
        customers.add(userName);
        System.out.println(String.format("There are %s people in front of you", (customers.size() - 1)));
        return customers;
    }

    // Ninja Bonus
    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(String.format("%s", product));
        double sum = 0;
        // double discount = .50;
        double total = 0;
        for (int i = 1; i <= maxQuantity; i++) {
            sum += price;
            if (i > 1) {
                double discount = .50;
                discount *= (i - 1);
                total = sum - discount;
            }
            else {
                total = sum;
            }
            System.out.println(String.format("%s - $%.2f", i, total));
        }
        // for (int i = 1; i <= maxQuantity; i++) {
        //     sum += price;
            // System.out.println(String.format("%s - $%.2f", i, sum));
        // }
    }
}