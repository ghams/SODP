package producerconsumer;

import java.nio.Buffer;

/**
 *
 * @author Daniel
 */
public class Producer extends java.lang.Object implements java.lang.Runnable {
    
    private final int max;
    //public static final int STOP_VALUE;
    private final Buffer buffer;
    
    /**
     *
     * @param max
     * @param buffer
     */
    public Producer(int max, Buffer buffer) {
        this.max = max;
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        for (int i=0; i < buffer.capacity(); i++) {
        }                
    }
    
}
