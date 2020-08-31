exports.seed = function (knex) {
  // Deletes ALL existing entries
  return knex("todos")
    .del()
    .then(function () {
      // Inserts seed entries
      return knex("todos").insert([
        { id: 1, title: "get the mail", user_id: 3 },
        { id: 2, title: "go to gym", user_id: 3 },
        { id: 3, title: "watch the movie", user_id: 3 },
        { id: 4, title: "go for walk", user_id: 3 },
        { id: 5, title: "ride the cycle", user_id: 3 },
      ]);
    });
};
