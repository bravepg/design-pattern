function Car(option) {
  this.doors = option.doors || 4;
}

function Truck(option) {
  this.size = option.size || 'big';
}

function VehicleFactory() {}
VehicleFactory.prototype.vehicleClass = Car;
VehicleFactory.prototype.createVehicle = function(option) {
  if (option.vehicleType === 'car') {
    this.vehicleClass = Car;
  } else {
    this.vehicleClass = Truck;
  }

  return new this.vehicleClass(option);
}

// 创建生成汽车的工厂实例
const vehicleFactory = new VehicleFactory();
const car = vehicleFactory.createVehicle({
  vehicleType: 'car',
  doors: 2,
});

console.log(car);

function TruckFactory() {
  VehicleFactory.call(this);
}

TruckFactory.prototype = Object.create(VehicleFactory.prototype);
TruckFactory.prototype.vehicleClass = Truck;

const truckFactory = new TruckFactory();
const truck = truckFactory.createVehicle({
  size: 'very big',
});
console.log(truck);
