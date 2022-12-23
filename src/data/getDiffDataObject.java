package data;

public class getDiffDataObject extends Thread {

    private Data currentData;

    //Constructor
    public getDiffDataObject(Data currentData) {
        this.currentData=currentData;
    }

    //Create 1 set of dx and dy and add them to currentData
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
            currentData.printValues();
            System.out.println("The current diff is " + currentDiff);
            try {
                sleep(NUM_OF_MILLIS_TO_WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}