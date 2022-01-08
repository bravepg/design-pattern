package com.tripp.state;

interface CarState {
    void run();
}

class OpenCarState implements CarState {

    @Override
    public void run() {
        System.out.println("关闭车门");
    }
}

class StopCarState implements CarState {

    @Override
    public void run() {
        System.out.println("打开车门");
    }
}

class Car {
    CarState carState;

    public Car(CarState carState) {
        this.carState = carState;
    }
    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public void run() {
        this.carState.run();
    }
}

public class Main {
    public static void main(String[] args) {
        CarState carState = new OpenCarState();
        Car car = new Car(carState);
        car.run();
        car.setCarState(new StopCarState());
        car.run();
    }
}
