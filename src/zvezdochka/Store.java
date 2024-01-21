package zvezdochka;

import java.util.LinkedList;
import java.util.Queue;

class Store {
    private final Queue<Integer> goods;
    private final int capacity;

    public Store() {
        this.goods = new LinkedList<>();
        this.capacity = 3;
    }

    public synchronized void put() throws InterruptedException {
        while (goods.size() == capacity) {
            wait();
        }
        goods.add(1);
        System.out.println("Производитель произвел 1 товар");
        notify();
    }

    public synchronized void get() throws InterruptedException {
        while (goods.isEmpty()) {
            wait();
        }
        goods.poll();
        System.out.println("Покупатель купил 1 товар");
        notify();
    }
}