var options = {
  client: "oracledb",
  connection: {
    host: "127.0.0.1",
    user: "AK",
    password: "9106447228",
    database: "orcl",
  },
  pool: {
    max: 50,
    min: 2,
    //acquireTimeout: 60 * 1000,
    createTimeoutMillis: 30000,
    acquireTimeoutMillis: 30000,
    idleTimeoutMillis: 30000,
    reapIntervalMillis: 1000,
    createRetryIntervalMillis: 100,
    propagateCreateError: false, // <- default is true, set to false
  },
};

module.exports = require("knex")(options);
