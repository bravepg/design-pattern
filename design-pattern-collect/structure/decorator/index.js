const plane = {
  fire: function() {
    console.log('发射普通子弹');
  },
}

const missileDecorator = function() {
  console.log('发射导弹');
}

const fire = plane.fire;
plane.fire = function() {
  fire();
  missileDecorator();
}

plane.fire();
