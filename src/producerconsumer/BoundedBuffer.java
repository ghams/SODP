/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

/**
 *
 * @author Daniel
 */
public class BoundedBuffer extends AbstractBuffer {

    private final int capacity;

    public BoundedBuffer(int capacity) throws java.lang.IllegalArgumentException {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return false;
    }

    public int take() {
        return 0;
    }

    public void put(int element) {
    }
}
