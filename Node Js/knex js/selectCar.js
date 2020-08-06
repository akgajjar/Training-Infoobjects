var knex = require("./knexServer.js");

knex
  .from("cars")
  .select("name", "price")
  .where("price", ">", "50000")
  .andWhere("id", "=", "1")
  .then((rows) => {
    for (row of rows) {
      console.log(`${row["name"]} ${row["price"]}`);
    }
  })
  .catch((err) => {
    console.log(err);
    throw err;
  })
  .finally(() => {
    knex.destroy();
  });
