var express = require('express'),
	bodyParser = require('body-parser'),
	util = require('./util'),
	cors = require('cors');

var app = express();


app.use(bodyParser.urlencoded({
    extended: false
}));

app.use(bodyParser.json());

app.all('*', function(req, res, next) {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Methods', 'PUT, GET, POST, DELETE, OPTIONS');
  res.header('Access-Control-Allow-Headers', 'Content-Type');
  next();
});

app.post('/send', util.sendMessage);

app.get('/conversations/:id1/:id2', util.getConversation);

app.post('/creategroup', util.creategroup);

app.post('/sendGroupMessage', util.sendGroupMessage);

app.get('/groupConversations/:gid', util.getGroupConversation);

app.listen(1234);

console.log('Listening on port 1234...');