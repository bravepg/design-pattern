Function.prototype.after= function(fn) {
  const self = this;
  return function() {
    const ret = self.apply(null, arguments);
    
    if (ret === 'nextSuccessor') {
      return fn.apply(null, arguments);
    }

    return ret;
  }
}

function get500(num) {
  if (num > 200) {
    console.log('get 500:', num);
  } else {
    return 'nextSuccessor';
  }
}

function get200(num) {
  if (num > 100) {
    console.log('get 200: ', num);
  } else {
    return 'nextSuccessor';
  }
}

const getChain = get500.after(get200);
getChain(120);