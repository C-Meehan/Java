public class Car {
    private int gas = 10;

    public Car() {};

    public Car(int gas) {
        this.gas = gas;
    }

    public String displayGas() {
        return String.format("Gas remaining: %s/10", gas);
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }
}