var knex = require("./knexServer.js");

const cars = [
  { name: "Audi", price: 52642 },
  { name: "Mercedes", price: 57127 },
  { name: "Skoda", price: 9000 },
  { name: "Volvo", price: 29000 },
  { name: "Bentley", price: 350000 },
  { name: "Citroen", price: 21000 },
  { name: "Hummer", price: 41400 },
  { name: "Volkswagen", price: 21600 },
];

knex("cars")
  .insert(cars)
  .then(() => console.log("data inserted"))
  .catch((err) => {
    console.log(err);
    throw err;
  })
  .finally(() => {
    knex.destroy();
  });
