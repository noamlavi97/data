/*Dear TA - Please note - there has been some changes to the classes between the sections.
This is because we were instructed to submit only the latest version
The previous versions can be created by uncommenting the lines*/

package data;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int MAX_INITIAL_VALUE_TO_ADD = 50, NUM_OF_THREADS = 4;

        Random r = new Random();
        // Create initial values for data
        int x = r.nextInt(MAX_INITIAL_VALUE_TO_ADD);
        int y = r.nextInt(MAX_INITIAL_VALUE_TO_ADD);
        // Create data object
        Data data = new Data(x, y);
        //Print the initial values
        System.out.println("The initial values are:");
        data.printValues();
        //Create update and diff threads and run them
        /*updateDataObject updateObject = new updateDataObject(data);
        getDiffDataObject diffObject = new getDiffDataObject(data);
        Thread updateObjectThread = new Thread(updateObject) {};
        Thread diffObjectThread = new Thread(diffObject) {};
        updateObjectThread.start();
        diffObjectThread.start();*/
        updateDataObject[] updateObject = new updateDataObject[NUM_OF_THREADS];
        getDiffDataObject[] diffObject = new getDiffDataObject[NUM_OF_THREADS];
        Thread[] updateObjectThread = new Thread[NUM_OF_THREADS];
        Thread[] diffObjectThread = new Thread[NUM_OF_THREADS];
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            updateObject[i] = new updateDataObject(data);
            diffObject[i] = new getDiffDataObject(data);
        }
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            updateObjectThread[i] = new Thread(updateObject[i]);
            diffObjectThread[i] = new Thread(diffObject[i]);
        }
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            updateObject[i].start();
            diffObject[i].start();
        }
    }
}
