// 构造器
function Car() {
  this.wheels = 4;
}

Car.prototype.drive = function() {
  console.log('car drive');
}

// new + 构造器
new Car();
