function Light() {
  this.state = FSM.off;
}

Light.prototype.onClick = function() {
  // this.state.onPress();
  // 需要修改 this
  this.state.onPress.apply(this);
}

const FSM = {
  on: {
    onPress: function() {
      console.log('关闭电灯');
      this.state = FSM.off;
    },
  },
  off: {
    onPress: function() {
      console.log('打开电灯');
      console.log('this', this);
      this.state = FSM.on;
    },
  },
};

const light = new Light();
light.onClick();
light.onClick();
