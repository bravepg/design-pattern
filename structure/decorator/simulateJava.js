class Plane {
  fire() {
    console.log('发射普通子弹')
  }
}

class MissileDecorator {
  constructor(plane) {
    this.plane = plane;
  }
  fire() {
    this.plane.fire();
    console.log('发射导弹')
  }
}

let plane = new Plane();
plane = new MissileDecorator(plane);

plane.fire();