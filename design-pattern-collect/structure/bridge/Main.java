package structure.bridge;

interface Device {
    boolean isEnabled();
    void enable();
    void disabled();
}

class Remote {
    Device device;

    public Remote(Device device) {
        this.device = device;
    }

    void togglePower() {
        if (device.isEnabled()) {
            device.disabled();
        } else {
            device.enable();
        }
    }
}

class Radio implements Device {
    boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disabled() {
        enabled = false;
    }
    
}



public class Main {
    public static void main(String[] args) {
        Radio radio = new Radio();
        Remote remote = new Remote(radio);
        remote.togglePower();
        System.out.println(radio.isEnabled());
    }
}