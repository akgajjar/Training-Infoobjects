const mysql = require('mysql');

const connection =  mysql.createConnection({
	host : 'localhost',
	user : 'root',
	password : '',
	database : 'tms',
});


//select all users
connection.query("select * from users",(err, rows, fields) => {
	console.log("successfully found users");
	res.json(rows);
});


//select all user By id
var queryString = "select * from users where id = ?";
var id = 1;
connection.query(queryString,[id],(err, rows, fields) => {
	if(err){
		console.log("users not found " + err);
		res.sendStatus(500);
		res.end();
		return;
	}
	console.log("successfully found users");
	
	//modify your row data like snake case to camel case etc.
	const users = rows.map((row)=>{
		return row	
	
	})
	res.json(rows);
});
