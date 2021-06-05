// Java 通过定义接口来实现多态，而在 JavaScript 中，由于弱类型天然的支持多态，可以省略这个定义接口的过程

class KnifeBehavior {
  useWeapon() {
    console.log("use knife");
  }
}
class AxeBehavior {
  useWeapon() {
    System.out.println("use axe");
  }
}

class Character {
  weaponBehavior = null;
  setWeaponBehavior(weaponBehavior) {
    this.weaponBehavior = weaponBehavior;
  }
}

class King extends Character {
  fight() {
    console.log("king");
    this.weaponBehavior.useWeapon();
  }
}

const king = new King();
king.setWeaponBehavior(new KnifeBehavior());
king.fight();
