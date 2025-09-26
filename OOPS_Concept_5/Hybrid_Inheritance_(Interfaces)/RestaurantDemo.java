package OOPs_Concept_5.Hybrid_Inheritance_Interfaces;

// Hybrid Inheritance: Restaurant Management System
interface Worker {
    void performDuties();
}

class PersonR {
    String name;
    int id;

    PersonR(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends PersonR implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " cooks delicious food.");
    }
}

class Waiter extends PersonR implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " serves food to customers.");
    }
}

public class RestaurantDemo {
    public static void main(String[] args) {
        Worker c = new Chef("Rahul", 1);
        Worker w = new Waiter("Amit", 2);

        c.performDuties();
        w.performDuties();
    }
}
