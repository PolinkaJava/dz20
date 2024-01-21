package zvezdochka;

class Consumer extends Thread {
    private final Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                store.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}