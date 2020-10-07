const express = require("express");
const fetch = require("node-fetch");
const redis = require("redis");
const CircularJSON = require("circular-json");

const PORT = process.env.PORT || 5000;
const REDIS_PORT = process.env.REDIS_PORT || 6379;

const client = redis.createClient(REDIS_PORT);

const app = express();

app.get("/repos/:username", fetchFromRedis,(req, res, next) => {
  getRepos(req.params)
    .then((response) => res.send(response))
    .catch((err) => console.log(err));
});


function setResponse(username, repos) {
    return `<h2> ${username} has ${repos} Github repos </h2>`;   
}

//make request to Github for data

function getRepos(params) {
  return new Promise((resolve, reject) => {
    console.log("Fetching Data....");
    const { username } = params;
    fetch(`https://api.github.com/users/${username}`)
      .then(async (response) => {

        response.json().then((data) => {
            const repos = data.public_repos;
            
            //set data to redis

            client.setex(username, 3600, repos);

          resolve(setResponse(username, repos));
        });
      })
      .catch((err) => {
        console.log(err);
        reject(err);
      });
  });
}

//catche middleware
function fetchFromRedis(req, res , next) {
    const { username } = req.params;
    client.get(username, (err, data) => {
        if (err) throw err;

        if (data != null)
            res.send(setResponse(username, data));
        else
            next();
    });
}

app.listen(PORT, () => {
  console.log(`App Listening on port  ${PORT}`);
});
