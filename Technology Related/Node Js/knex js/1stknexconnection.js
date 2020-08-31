var knex = require("knex")({
  client: "mysql",
  connection: {
    host: "127.0.0.1",
    user: "AK",
    password: "9106447228",
    database: "orcl",
  },
  pool: {
    afterCreate: function (conn, done) {
      // in this example we use OracleDb driver's connection API
      conn.query('SET timezone="UTC";', function (err) {
        if (err) {
          // first query failed, return error and don't try to make next query
          done(err, conn);
        } else {
          // do the second query...
          conn.query("SELECT set_limit(0.01);", function (err) {
            // if err is not falsy, connection is discarded from pool
            // if connection aquire was triggered by a query the error is passed to query promise
            done(err, conn);
          });
        }
      });
    },
  },
  acquireConnectionTimeout: 10000,
});
