package tms.lessons.lesson_20.task3;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Thread threadBuyer = new Thread(new Buyer(store));
        Thread threadManufacture = new Thread(new Manufacture(store));

        threadBuyer.start();
        threadManufacture.start();

    }
}
