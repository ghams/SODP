/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return false;
    }

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

    public synchronized void put(int element) {
        while (qq.size() == getCapacity()) {
            try {
                wait();
            } catch (InterruptedException e) { /* ignore */ }
        }
        int item = 0;
        qq.add(item);
        notifyAll();
    }
}