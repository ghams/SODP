package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Daniel
 */
public class BoundedBuffer extends AbstractBuffer {

    private final int capacity;
    Queue<Integer> qq = new LinkedList();

    public BoundedBuffer(int capacity) throws java.lang.IllegalArgumentException {
        this.capacity = capacity;
    }

    /**
     *
     * @return Capacity of this buffer
     */
    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return false;
    }

    /**
     *
     * @return The item that was removed
     */
    public synchronized int take() {
        while (qq.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) { /* ignore */ }
        }
        int item = qq.poll();
        notifyAll();
        return item;
    }

    /**
     *
     * @param element item to be inserted
     */
    public synchronized void put(int element) {
        while (qq.size() == getCapacity()) {
            try {
                wait();
            } catch (InterruptedException e) { /* ignore */ }
        }
        qq.add(element);
        notifyAll();
    }
}