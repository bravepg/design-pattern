package behavior.strategy;

interface WeaponBehavior {
    public void useWeapon();
}
class KnifeBehavior implements WeaponBehavior {
    public void useWeapon() {
        System.out.println("use knife");
    }
}
class AxeBehavior implements WeaponBehavior {
    public void useWeapon() {
        System.out.println("use axe");
    }
}

abstract class Character {
    WeaponBehavior weaponBehavior;
    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
   abstract public void fight();
}

class King extends Character {
    public void fight() {
        System.out.println("king");
        this.weaponBehavior.useWeapon();
    }
}
public class Main {
    public static void main(String[] args) {
        King king = new King();
        king.setWeaponBehavior(new KnifeBehavior());
        king.fight();
    }
}
