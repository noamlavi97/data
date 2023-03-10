/*Dear TA - Please note - there has been some changes to the classes between the sections.
This is because we were instructed to submit only the latest version
The previous versions can be created by uncommenting the lines*/

package data;

import java.util.Random;

public class updateDataObject extends Thread {

    private Data currentData;

    // Constructor
    public updateDataObject(Data currentData) {
        this.currentData = currentData;
    }

    // Create 1 set of dx and dy and add them to currentData
    public void addToData() {
        final int MAX_VALUE_TO_ADD = 50;
        int dx, dy;
        Random r = new Random();
        dx = r.nextInt(MAX_VALUE_TO_ADD * 2) - MAX_VALUE_TO_ADD;
        dy = r.nextInt(MAX_VALUE_TO_ADD * 2) - MAX_VALUE_TO_ADD;
        currentData.update(dx, dy);
    }

    // Run method
    @Override
    public void run() {
        final int NUM_OF_VALUES_TO_ADD = 10, NUM_OF_MILLIS_TO_WAIT = 1000;
        super.run();
        for (int i = 0; i < NUM_OF_VALUES_TO_ADD; i++) {
            addToData();
            try {
                sleep(NUM_OF_MILLIS_TO_WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}