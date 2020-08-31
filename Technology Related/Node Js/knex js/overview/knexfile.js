module.exports = {
  development: {
    client: "oracledb",
    connection: "AK@//localhost:1521/orcl",
    migrations: {
      directory: (_dirname = "/db/migrations"),
    },
    seeds: {
      directory: (_dirname = "/db/seeds"),
    },
  },
  production: {
    client: "oracledb",
    connection: process.env.DATABSE_URL,
    migrations: {
      directory: (_dirname = "/db/migrations"),
    },
    seeds: {
      directory: (_dirname = "/db/seeds/productions"),
    },
  },
};
