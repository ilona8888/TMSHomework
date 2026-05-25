package tms.lessons.lesson_20.task3;

public class Buyer implements Runnable{

    Store store;

    public Buyer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i ++) {
            try {
                store.sellProduct();
                Thread.sleep(2200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
