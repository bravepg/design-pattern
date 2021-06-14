const Beverage = function(params) {
  const boilWater = function() {
    console.log('把水煮沸');
  }

  const brew = params.brew || function() {
    throw new Error('必须传递 brew 方法');
  }

  function F() {}
  F.prototype.prepare = function() {
    boilWater();
    brew();
  }

  return new F();
}

const coffee = Beverage({
  brew: function() {
    console.log('用沸水冲泡咖啡');
  }
});

coffee.prepare();
