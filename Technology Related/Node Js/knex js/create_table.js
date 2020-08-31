const options = {
  client: "oracledb",
  connection: {
    host: "127.0.0.1",
    user: "AK",
    password: "9106447228",
    database: "orcl",
  },
};

const knex = require("knex")(options);

/*knex.schema
  .createTable("cars", (table) => {
    table.increments("id");
    table.string("name");
    table.integer("price");
  })
  .then(() => console.log("table created"))
  .catch((err) => {
    console.log(err);
    throw err;
  })
  .finally(() => {
    knex.destroy();
  });
*/

knex.schema
  .createTable("teacherstudent", (table) => {
    table.varchar("TEACHER_ID").references("TEACHER_ID").inTable("TEACHER");
    table.varchar("STUDENT_ID").references("STUDENT_ID").inTable("STUDENT");
    table.primary(["TEACHER_ID", "STUDENT_ID"]);
  })
  .then(() => console.log("table created"))
  .catch((err) => {
    console.log(err);
    throw err;
  })
  .finally(() => {
    knex.destroy();
  });
