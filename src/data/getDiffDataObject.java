/*Dear TA - Please note - there has been some changes to the classes between the sections.
This is because we were instructed to submit only the latest version
The previous versions can be created by uncommenting the lines*/

package data;

public class getDiffDataObject extends Thread {

    private Data currentData;

    //Constructor
    public getDiffDataObject(Data currentData) {
        this.currentData=currentData;
    }

    //Returns the difference between x and y
    public int getDiffOfDataValues() {
        return currentData.getDiff();
    }

    //Run method
    @Override
    public void run() {
        final int NUM_OF_VALUES_TO_CHECK_DIFF=10, NUM_OF_MILLIS_TO_WAIT=1000;
        int currentDiff;
        super.run();
        for (int i=0; i<NUM_OF_VALUES_TO_CHECK_DIFF; i++) {
            currentDiff=getDiffOfDataValues();
            System.out.println("The current diff is " + currentDiff);
            try {
                sleep(NUM_OF_MILLIS_TO_WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}