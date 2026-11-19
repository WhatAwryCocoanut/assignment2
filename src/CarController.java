
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Point;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // The delay (ms) corresponds to 20 updates/second (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // TODO A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    

    public void startTimer() {       
        this.timer.start();
    }

    // will cause it to clitch out if it doesn't return full on screen in one frame
    public void collision (Car car){
            if((car.getX() < 0 && car.getDirection() == 3 )||
            ( car.getY() < 0 && car.getDirection() == 0) || 
            (car.getX() > CarView.X - 15 - frame.drawPanel.imageWidth && car.getDirection() == 1)||
            (car.getY() > CarView.Y - 240 - frame.drawPanel.imageHeight && car.getDirection() == 2 )){
            car.uTurn();        
        }
    }
    /* Each step, the TimerListener moves all cars in the list and tells the
     * view to update its images. TODO Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < cars.size(); i++){
                Car car = cars.get(i);
                car.move();
                collision(car);
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(i, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.revalidate();
                frame.drawPanel.repaint();
            }
             
        }
    }


    void gas(int amount) {
        // TODO adapt to your needs
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
        
    }    
    void brake(int amount){
        double brake = ((double)amount) / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    }
    void turnLeft(){
        for (Car car : cars){
            car.turnLeft();
        }
    }
    void turnRight(){
        for (Car car : cars){
            car.turnRight();
        }
    }
    void startAllCars(){
        for(Car car : cars){
            car.startEngine();
        }
    }
    void stopAllCars(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
    void turboOn(){
        for (Car car : cars){
            car.setTurboOn();
        }
    }
    void tuboOff(){
        for (Car car : cars){
            car.setTurboOff();
        }
    }
}
