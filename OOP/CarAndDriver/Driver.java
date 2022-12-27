public class Driver extends Car {

    public Driver() {
        super();
    }

    public String drive() {
        setGas(getGas() - 1);
        return String.format("You decided to Drive. Gas remaining: %s/10", getGas());
    }

    public String boosters() {
        if (getGas() < 3) {
            return String.format("You don't have enough fuel to boost. Gas remaining is still: %s/10", getGas());
        }
        else {
            setGas(getGas() - 3);
            return String.format("You used boosters. Gas remaining: %s/10", getGas());
        }
    }

    public String refuel() {
        if (getGas() > 8) {
            return String.format("Save your money and refuel later. Gas remaining: %s/10", getGas());
        }
        else {
            setGas(getGas() + 2);
            return String.format("You refueled. Your current gas level is: %s/10", getGas());
        }
    }
}