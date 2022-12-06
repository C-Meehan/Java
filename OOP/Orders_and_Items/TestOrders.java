import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Items item1 = new Items();
        item1.name = "drip";
        item1.price = 2.50;

        Items item2 = new Items();
        item2.name = "mocha";
        item2.price = 3.00;

        Items item3 = new Items();
        item3.name = "cappuccino";
        item3.price = 3.50;

        Items item4 = new Items();
        item4.name = "latte";
        item4.price = 4.00;

        // Order variables -- order1, order2 etc.
        Orders order1 = new Orders();
        order1.name = "Cindhuri";
        order1.ready = true;
        // System.out.println(order1);

        Orders order2 = new Orders();
        order2.name = "Jimmy";
        order2.items.add(item1);
        order2.total += item1.price;
        order2.ready = true;
        // System.out.println(order2.items);


        Orders order3 = new Orders();
        order3.name = "Noah";
        order3.items.add(item3);
        order3.total += item3.price;

        Orders order4 = new Orders();
        order4.name = "Sam";
        order4.items.add(item4);
        order4.items.add(item4);
        order4.items.add(item4);
        order4.total += item4.price * 3;


        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
