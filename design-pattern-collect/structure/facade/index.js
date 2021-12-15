function doWorkA() {
  console.log('A doWork');
}

function doWorkB() {
  console.log('B doWork');
}

function doWorkC() {
  console.log('C doWork');
}

const facade = {
  doWork: function() {
    doWorkA();
    doWorkB();
    doWorkC();
  }
}
