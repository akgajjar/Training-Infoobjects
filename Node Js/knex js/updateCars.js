var knex = require("./knexServer.js");

var car = {
  id: 2,
  name: "Mercedes",
  price: 57127,
};

knex("cars")
  .update(car)
  .where("id", "=", car.id)
  .then((rows) => {
    // the argument here as you stated
    // describes the number of rows updated
    // therefore if no row found no row will be updated
    if (!rows) {
      return;
    }
    console.log("car Updated");
    return;
  })
  .catch((e) => {
    console.log(e);
    throw e;
  });
