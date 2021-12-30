// 跟 Java 的思想非常类似，有 next hasNext 的接口
// 但是又有其独特之处，不存在将 iterator 设置为对象属性的操作
function Iterator(obj) {
  let current = 0;
  
  function hasNext() {
    return current < obj.length;
  }

  function next() {
    return obj[current++];
  }

  return {
    hasNext,
    next,
  }
}