import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Items item1 = new Items("drip", 2.5);
        Items item2 = new Items("mocha", 3.0);
        Items item3 = new Items("cappuccino", 3.5);
        Items item4 = new Items("latte", 4.0);

        // Order variables -- order1, order2 etc.
        Orders order1 = new Orders();
        Orders order2 = new Orders();

        Orders order3 = new Orders("Dan");
        Orders order4 = new Orders("James");
        Orders order5 = new Orders("Bill");

        order1.addItem(item1);
        order1.addItem(item3);

        order2.addItem(item1);
        order2.addItem(item4);

        order3.addItem(item3);
        order3.addItem(item3);

        order4.addItem(item2);
        order4.addItem(item4);

        order5.addItem(item2);
        order5.addItem(item4);

        System.out.println(order1.getStatusMessage());

        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.println(order2.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}
