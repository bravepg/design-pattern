class Beverage {
  prepare() {
    this.boilWater();
    this.brew();
    this.pourInCup();
    this.addCondiments();
  }

  boilWater() {
    console.log('把水煮沸');
  }

  brew() {}

  pourInCup() {
    console.log('倒入杯子');
  }

  addCondiments() {}
}

class Coffee extends Beverage {
  brew() {
    console.log('冲泡咖啡');
  }
  addCondiments() {
    console.log('加糖和牛奶');
  }
}

class Tea extends Beverage {
  brew() {
    console.log("浸泡茶叶");
  }
  addCondiments() {
    console.log("加柠檬");
  }
}

const coffee = new Coffee();
coffee.prepare();
const tea = new Tea();
tea.prepare();
