console.log('start Initialize knex');
var pgConfig = require('../../epConfig.js').pgSqlConfig;
knex_Pg = require('knex')({
    client: "pg",
    connection: {
        host: pgConfig.host,
        user: pgConfig.user,
        database: pgConfig.database,
        password: pgConfig.password
    },
    pool: {
        min: pgConfig.minPool,
        max: pgConfig.maxPool
    },
    schema: pgConfig.schema,
    acquireConnectionTimeout: pgConfig.acquireConnectionTimeout
});
console.log('Done Initialize knex');
module.exports = knex_Pg;