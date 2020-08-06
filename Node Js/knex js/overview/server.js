var express = require("express");
var bodyParser = require("body-parser");
var port = process.env.port || 8000;
var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.listen(port, function () {
  console.log("listening on port : ", port);
});
