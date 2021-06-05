// 在 JavaScript 语言中，函数是对象，因此我们从本质上来说，没有必要把一个个策略封装成对象
const strategies = {
  knifeBehavior: function() {
    console.log("use knife");
  },
  axeBehavior: function() {
    console.log("use axe");
  }
}

function fight(behavior) {
  strategies[behavior]();
}

fight('knifeBehavior');