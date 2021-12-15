// function Player(name, teamColor) {
//   this.parterns = [];
//   this.enemies = [];
//   this.name = name;
//   this.teamColor = teamColor;
//   this.live = true;
// }

// Player.prototype.win = function() {
//   console.log(this.name, ': win');
// }

// Player.prototype.lost = function() {
//   console.log(this.name, ': lost');
// }

// Player.prototype.die = function() {
//   let all_dead = true;

//   this.live = false;

//   for (let i = 0; i < this.parterns.length; i++) {
//     if (this.parterns[i].live) {
//       all_dead = false;
//     }
//   }

//   if (all_dead) {
//     this.lost();
//     for (let i = 0; i < this.parterns.length; i++) {
//       this.parterns[i].lost();
//     }
//     for (let i = 0; i < this.enemies.length; i++) {
//       this.enemies[i].win();
//     }
//   }
// }

// const players = [];

// function playFactory(name, teamColor) {
//   const newPlayer = new Player(name, teamColor);
//   for (let i = 0; i < players.length; i++) {
//     if (players[i].teamColor === newPlayer.teamColor) {
//       players[i].parterns.push(newPlayer);
//       newPlayer.parterns.push(players[i]);
//     } else {
//       players[i].enemies.push(newPlayer);
//       newPlayer.enemies.push(players[i]);
//     }
//   }

//   players.push(newPlayer);

//   return newPlayer;
// }


// const playerA = playFactory('A', 'red');
// const playerB = playFactory('B', 'red');
// const playerC = playFactory('C', 'red');
// const playerD = playFactory('D', 'red');

// const playerE = playFactory('E', 'blue');
// const playerF = playFactory('F', 'blue');
// const playerG = playFactory('G', 'blue');
// const playerH = playFactory('H', 'blue');

// playerA.die();
// playerB.die();
// playerC.die();
// playerD.die();


function Player(name, teamColor) {
  this.name = name;
  this.teamColor = teamColor;
  this.living = true;
}

Player.prototype.win = function() {
  console.log(this.name, ': win');
}

Player.prototype.lose = function() {
  console.log(this.name, ': lost');
}

Player.prototype.die = function() {
  this.living = false;

  playMediator.receiveMessage('playerDead', this);
}

const playMediator = (function() {
  const players = {};
  const operations = {};

  operations.addPlayer = function(player) {
    const teamColor = player.teamColor;

    players[teamColor] = players[teamColor] || [];

    players[teamColor].push(player);
  }

  operations.removePlayer = function(player) {
    const teamColor = player.teamColor;

    const teamPlayers = players[teamColor] || [];

    for (let i = 0; i < teamPlayers.length; i++) {
      if (teamPlayers[i] === player) {
        teamPlayers.splice(i, 1);
      }
    }
  }

  operations.playerDead = function(player) {
    let all_dead = true;

    const teamColor = player.teamColor;
    const teamPlayers = players[teamColor] || [];

    for (let i = 0; i < teamPlayers.length; i++) {
      if (teamPlayers[i].living) {
        all_dead = false;
      }
    }

    if (all_dead) {
      for (let i = 0; i < teamPlayers.length; i++) {
        teamPlayers[i].lose();
      }


      for (color in players) {
        if (color !== teamColor) {
          const otherPlayers = players[color] || [];

          for (let i = 0; i < otherPlayers.length; i++) {
            otherPlayers[i].win();
          }
        }
      }
    }
  }

  const receiveMessage = function() {
    const action = Array.prototype.shift.call(arguments);

    operations[action].apply(this, arguments);
  }

  return {
    players,
    operations,
    receiveMessage,
  }
})();

function playFactory(name, teamColor) {
  const newPlayer = new Player(name, teamColor);
  playMediator.receiveMessage('addPlayer', newPlayer);
  
  return newPlayer;
}

const playerA = playFactory('A', 'red');
const playerB = playFactory('B', 'red');
const playerC = playFactory('C', 'red');
const playerD = playFactory('D', 'red');

const playerE = playFactory('E', 'blue');
const playerF = playFactory('F', 'blue');
const playerG = playFactory('G', 'blue');
const playerH = playFactory('H', 'blue');

const playerI = playFactory('I', 'yellow');

playerA.die();
playerB.die();
playerC.die();
playerD.die();

// console.log('playMediator', playMediator);
