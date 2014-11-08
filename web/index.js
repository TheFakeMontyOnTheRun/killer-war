var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.get('/', function(req, res){
  res.sendfile(__dirname + '/board.html');
});


app.get('/player', function(req, res){
    res.sendfile(__dirname + '/player.html');
});

io.on('connection', function(socket){
  socket.on('board', function(msg){
    io.emit('board', msg);
  });
});

http.listen(3001, function(){
  console.log('listening on *:3001');
});