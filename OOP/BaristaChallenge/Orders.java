import java.util.ArrayList;

public class Orders {
    private String name;
    private boolean ready;
    private ArrayList<Items> items = new ArrayList<Items>();

    public Orders() {
        this.name = "guest";
        this.ready = false;
    }

    public Orders(String name) {
        this.name = name;
        this.ready = false;
    }

    public void addItem(Items item) {
        this.items.add(item);
    }

    public String getStatusMessage() {
        String message = "";
        if (this.ready == true) {
            message = "Your order is ready";
        }
        else {
            message = "Thank you for waiting. Your order will be ready soon.";
        }
        return message;
    }

    public double getOrderTotal() {
        double total = 0.0;
        for (Items i: this.items) {
            total += i.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.printf("Customer Name: %s", this.name);
        for (Items i: this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }



    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}