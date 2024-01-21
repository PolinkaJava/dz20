package zvezdochka;

class Producer extends Thread {
    private final Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                store.put();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}