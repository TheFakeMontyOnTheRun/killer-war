var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.get('/', function(req, res){
  res.sendfile(__dirname + '/board.html');
});


app.get('/player', function(req, res){
    res.sendfile(__dirname + '/player.html');
});

var usernames = {};

io.on('connection', function(socket){
  socket.on('board', function(msg){
    io.emit('board', msg);
  });

    // when the client emits 'adduser', this listens and executes
    socket.on('adduser', function(username){
        // we store the username in the socket session for this client
        socket.username = username;
        // add the client's username to the global list
        usernames[username] = username;
        //// echo to client they've connected
        //socket.emit('updatechat', 'SERVER', 'you have connected');
        //// echo globally (all clients) that a person has connected
        //socket.broadcast.emit('updatechat', 'SERVER', username + ' has connected');
        //// update the list of users in chat, client-side
        //io.sockets.emit('updateusers', usernames);
        times = ['red', 'blue'];
        time = times[Math.floor(Math.random()*times.length)];
        io.sockets.emit('create', '{"id" : "'+username+'", "time": "'+time+'"}');
    });



});

http.listen(3001, function(){
  console.log('listening on *:3001');
});