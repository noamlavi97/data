//Dear TA - Please note - there has been some changes to the classes between the sections,
//This is because we were instructed to submit only the latest version
//The previous version can be noted by uncommenting the lines*/

package data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Data {
    private int x = 0;
    private int y = 0;
    // If the boolean is true it means that an update in being made, and therefore
    // can't calculate the diff
    // If the boolean is false it means that the values are being read
    private boolean valuesInUpdate = false;

    // Use the lock mechanism to protect the data from being updated while reading
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    // Constructor
    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Difference between the x and y values
    /* public int getDiff() { */
    public int getDiff() {
        lock.lock();
        int returnValue;
        // Wait for the update to complete
        try {
            while (valuesInUpdate) {
            /*while (valuesInUpdate) {*/
                condition.await();
            }
        } catch (InterruptedException e) {}
        finally {
            returnValue = Math.abs(x - y);
            System.out.println("The values the diff is calculated with are:");
            printValues();
            /*valuesInUpdate = false;*/
            lock.unlock();
        }
        return (returnValue);
    }

    // Add dx to the x value, and dy to the y value
    /* public void update(int dx, int dy) { */
    public synchronized void update(int dx, int dy) {
        lock.lock();
        // Wait for the reading / other update to complete
        try {
            while (valuesInUpdate) {
                condition.await();
            }
            //Now we are in a new update
            valuesInUpdate=true;
            System.out.println("The values before adding dx and dy are:");
            printValues();
            System.out.println("Values to add: dx=" + dx + ", dy=" + dy);
            x = x + dx;
            y = y + dy;
            System.out.println("The values after adding dx and dy are:");
            printValues();
        } catch (InterruptedException e) {}
        finally {
            /*The following line is for section C only*/
            valuesInUpdate=false;
            condition.signalAll();
            lock.unlock();
        }
    }

    // Print the current values
    public void printValues() {
        System.out.println("x=" + x + " y=" + y);
    }
}