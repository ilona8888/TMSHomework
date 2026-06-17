package tms.lessons.lesson_20.task3;

public class Manufacture implements Runnable {

    Store store;

    public Manufacture(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        for(int i = 0; i < 5; i++){
            try {
                store.addProductToStore();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
