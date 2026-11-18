
import java.awt.*;

public class Saab95 extends Car{
    
    public Saab95() {
        nrDoors = 2;
        setColor(Color.red);
        enginePower = 125;
        setTurboOn();
        setTurboOff();
        modelName = "Saab95";
        stopEngine();
        x = 100;
        y = 300;
        xy_direction_counter = 0;
    }
        
    @Override 
    public double speedFactor() {
        double turbo = 1;
        if(getTurbo()) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}