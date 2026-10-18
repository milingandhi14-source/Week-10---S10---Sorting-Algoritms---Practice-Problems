
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class p2 {

    static class Customer {
        int id;
        String name;

        Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Customer)) return false;

            Customer other = (Customer) obj;
            return id == other.id && Objects.equals(name, other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "(" + id + ", " + name + ")";
        }
    }

    public static void main(String[] args) {
        Set<Customer> registry = new HashSet<>();

        Customer c1 = new Customer(101, "Asha");
        Customer c2 = new Customer(101, "Asha");
        Customer c3 = new Customer(102, "Ravi");

        System.out.println(registry.add(c1));
        System.out.println(registry.add(c2));
        System.out.println(registry.add(c3));

        System.out.println("Unique count: " + registry.size());
        System.out.println("Contains Asha: "
                + registry.contains(new Customer(101, "Asha")));
    }
}
