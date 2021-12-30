const multiply = function() {
  let result = 1;
  for (let i = 0; i < arguments.length; i++) {
    result = result * arguments[i];
  }

  console.log('执行啦');

  return result;
}

// 缓存代理的使用
// 在静态代理中，本体和代理有很清晰的结构的上的规定（均继承同一个 interface）
// 在 JavaScript，函数均可以执行，从某种程序上说也就是实现了同一个接口（可执行）
const createProxyFactory = function(fn) {
  // 静态语言如果希望实现缓存代理，cache 一般会作为成员变量
  const cache = {};
  return function() {
    const key = Array.prototype.join.call(arguments, ',');

    if (cache[key]) {
      return cache[key];
    }
    return cache[key] = fn.apply(this, arguments);
  }
}

const multiplyProxy = createProxyFactory(multiply);

console.log(multiplyProxy(1, 2, 3));
console.log(multiplyProxy(1, 2, 3));