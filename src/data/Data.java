package data;

public class Data {
    private int x = 0;
    private int y = 0;
    
    //Constructor
    public Data (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //Difference between the x and y values
    public int getDiff() {
        return (Math.abs(x-y));
    }

    //Add dx to the x value, and dy to the y value
    public void update(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    //Print the current values
    public void printValues() {
        System.out.println("x="+x+" y="+y);
    }
}