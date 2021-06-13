package behavior.observer.observer;

import java.util.ArrayList;

interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

interface Observer {
    public void update(float temp, float humidity, float pressure);
}

interface Displayment {
    public void display();
}

class WeatherData implements Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private float temp;
    private float humidity;
    private float pressure;

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(temp, humidity, pressure);
        }
    }

    public void measureChanged() {
        notifyObservers();
    }

    public void setMeasureChanged(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measureChanged();
    }
}

class CurrentConditionsDisplay implements Observer, Displayment {
    private float temp;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        // 保持对 subject 对引用，是为了之后取消订阅和获取主题状态更加方便
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsDisplay" + temp + humidity + weatherData);
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasureChanged(18, 20, 24);
    }
}
