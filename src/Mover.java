import java.awt.*;

public class Mover  implements Runnable {

    int time, pixels;
    boolean startStop, left = true;

    public Mover(int x, boolean b, int pix) {

        time = x;
        startStop = b;
        pixels = pix;

    }

    public void run() {

        int intX = MouseInfo.getPointerInfo().getLocation().x;
        int intY = MouseInfo.getPointerInfo().getLocation().y;
        while (startStop) {

            try
            {
                intX = MouseInfo.getPointerInfo().getLocation().x;
                intY = MouseInfo.getPointerInfo().getLocation().y;
            }catch (NullPointerException e)
            {
                //JOptionPane.showMessageDialog(null, "AHHH LA VARA SE DESVERGOOOO");
                //System.exit(1);
            }


            Robot robot;
            try {
                robot = new Robot();
                if(left){
                    robot.mouseMove(intX - pixels, intY);
                    left = false;
                }
                else{
                    robot.mouseMove(intX + pixels, intY);
                    left = true;
                }
            } catch (AWTException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }// Close while loop
    }

    void clearData(){

        time = 0;
        pixels = 0;
    }
    void setTime(int x){

        time = x * 1000;
    }

    void setPixels(int x){
        pixels = x;
    }


    public void setStartStop(boolean value) {
        startStop = value;
    }

}