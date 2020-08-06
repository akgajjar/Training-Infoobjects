var options = {
  client: "oracledb",
  connection: {
    host: "127.0.0.1",
    user: "AK",
    password: "9106447228",
    database: "orcl",
  },
};

module.exports = require("knex")(options);
