module.exports = {
  pGConfig: {
    client: "pg",
    connection: {
      host: "",
      user: "",
      database: "",
      password: "",
      port: 5432,
    },
    schema: "schema_name",
    minPool: 0,
    maxPool: 10,
    acquireConnectionTimeout: 10000
  },
  env: {
    hostName: "localhost",
    ipAddr: "localhost",
    port: "4471",
    protocol: "http"
  },
  eureka: {
    protocol: "http",
    host: "localhost",
    port: 9999,
    servicePath: "/eureka/v2/apps/"
  },
};
