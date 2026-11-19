
import java.awt.*;

public class Saab95 extends Car{
    
    public Saab95(double x, double y) {
        nrDoors = 2;
        setColor(Color.red);
        enginePower = 125;
        setTurboOn();
        setTurboOff();
        modelName = "Saab95";
        stopEngine();
        this.x =x;
        this.y = y;
        xy_direction_counter = 0;
    }
        
    @Override 
    public double speedFactor() {
        double turbo = 1;
        if(getTurbo()) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}