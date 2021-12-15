function Singleton(fn) {
  let result = null;
  return function() {
    return result || (result = fn.apply(this, arguments));
  }
}

// 这是来自于 JavaScript 设计模式与开发实践中的写法，但是对于如今的大型 web 来说
// 这种写法或许失去了使用价值，本质是因为现在的应用均使用 class 的写法