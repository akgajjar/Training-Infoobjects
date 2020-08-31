exports.seed = function (knex) {
  // Deletes ALL existing entries
  return knex("users")
    .del()
    .then(function () {
      // Inserts seed entries
      return knex("users").insert([
        { id: 1, name: "Aniket", email: "aniket@gmail.com" },
        { id: 2, name: "Yesha", email: "yesha@gmail.com" },
        { id: 3, name: "Harsh", email: "harsh@gmail.com" },
      ]);
    });
};
