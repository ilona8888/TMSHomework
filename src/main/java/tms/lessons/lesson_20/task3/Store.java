package tms.lessons.lesson_20.task3;

public class Store {
    private int storage = 0;


    public synchronized void addProductToStore() throws InterruptedException {
        while (storage == 3){
            wait();
        }
        storage++;
        System.out.println("Поставщик привез товар");
        notifyAll();

    }

    public synchronized void sellProduct() throws InterruptedException {
        while (storage == 0) wait();
        storage--;
        System.out.println("Покупатель купил товар");
        notifyAll();
    }
}
