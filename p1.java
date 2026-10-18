
public class p1 {

    interface Dimmable {
        void dim(int level);
    }

    interface Schedulable {
        void schedule(String time);
    }

    interface EnergyMonitor {
        void showEnergy();
    }

    static abstract class Device {
        String id;
        boolean on;

        Device(String id) {
            this.id = id;
        }

        void turnOn() {
            on = true;
            System.out.println(id + " is ON");
        }

        void turnOff() {
            on = false;
            System.out.println(id + " is OFF");
        }
    }

    static class Light extends Device
            implements Dimmable, Schedulable {
        Light(String id) {
            super(id);
        }

        public void dim(int level) {
            System.out.println(id + " dimmed to " + level);
        }

        public void schedule(String time) {
            System.out.println(id + " scheduled " + time);
        }
    }

    static class Fan extends Device implements Schedulable {
        Fan(String id) {
            super(id);
        }

        public void schedule(String time) {
            System.out.println(id + " scheduled " + time);
        }
    }

    static class Plug extends Device implements EnergyMonitor {
        double energy;

        Plug(String id, double energy) {
            super(id);
            this.energy = energy;
        }

        public void showEnergy() {
            System.out.println(id + " energy " + energy + " kWh");
        }
    }

    public static void main(String[] args) {
        Light light = new Light("L1");
        Fan fan = new Fan("F1");
        Plug plug = new Plug("P1", 12);

        light.turnOn();
        light.dim(40);

        if (fan instanceof Dimmable) {
            ((Dimmable) fan).dim(30);
        } else {
            System.out.println("F1 rejected: DIM unsupported");
        }

        fan.schedule("22:00");

        plug.showEnergy();
        System.out.println("L1 rejected: ENERGY unsupported");
    }
}
