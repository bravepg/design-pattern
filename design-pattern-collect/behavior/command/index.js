const MenuBar = {
  add: function() {
    console.log('增加子菜单');
  },
};

function menuBarCommand(receiver) {
  return function() {
    receiver.add();
  }
}

const fn = menuBarCommand(MenuBar);

fn();

