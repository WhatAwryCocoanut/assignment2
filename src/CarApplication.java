void main() {
    // Instance of this class
    CarController cc = new CarController();

    // ADD cars to the list of cars that will show up in the application
    cc.cars.add(new Volvo240(0, 0));
    cc.cars.add(new Saab95(300, 150));

    // Start a new view and send a reference to the controller
    cc.frame = new CarView("CarSim 1.0", cc);
    cc.startTimer();
}