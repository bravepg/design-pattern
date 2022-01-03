const googleMap = {
  show: function() {
    console.log('开始渲染 Google 地图');
  },
};

const baiduMap = {
  display: function() {
    console.log('开始渲染百度地图');
  },
};

function render(obj) {
  if (typeof obj.show === 'function') {
    obj.show();
  }
};

const baiduMapAdapter = {
  show: function() {
    baiduMap.display();
  },
};

render(googleMap);
render(baiduMapAdapter);
