var knex = require("./knexServer.js");

knex("cars")
  .where("id", 7)
  .del()
  .then((rows) => {
    console.log("Cars Deleted!!!!!");
    return;
  })
  .catch((err) => {
    console.log(err);
    throw err;
  })
  .finally(() => {
    knex.destroy();
  });
