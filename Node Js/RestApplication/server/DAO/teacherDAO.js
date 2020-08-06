const knex = require("../knexServer.js");
module.exports = {
  insertTeacher: (teacher) => {
    knex
      .from("TEACHER")
      .orderBy("TEACHER_ID", "desc")
      .limit(1)
      .then((row) => {
        if (row.length == 0) {
          teacher.TEACHER_ID = 1;
        }
        teacher.TEACHER_ID = row["TEACHER_ID"] + 1;
        knex("TEACHER")
          .insert(teacher)
          .then(() => console.log("Teacher  inserted!!!!!"))
          .catch((err) => {
            console.log(err);
            throw err;
          });
      })
      .catch((err) => {
        console.log(err);
        throw err;
      });
  },

  updateTeacher: (teacher) => {
    knex("TEACHER")
      .update(car)
      .where("TEACHER_ID", "=", teacher.TEACHER_ID)
      .then((rows) => {
        // the argument here as you stated
        // describes the number of rows updated
        // therefore if no row found no row will be updated
        if (!rows) {
          return { success: false };
        }
        console.log("Teacher Updated!!!!!");
        return { success: true };
      })
      .catch((error) => {
        console.log(error);
        throw error;
      });
  },

  deleteTeacher: (teacherId) => {
    knex("TEACHER")
      .where("TEACHER_ID", teacherId)
      .del()
      .then((rows) => {
        console.log("Teacher Deleted!!!!!");
        return;
      })
      .catch((err) => {
        console.log(err);
        throw err;
      });
  },

  findTeacherById: (teacherId, res) => {
    knex
      .from("TEACHER")
      .select("*")
      .where("TEACHER_ID", "=", teacherId)
      .then((row) => {
        if (row.length == 0 || !row) {
          res.status(400);
          res.send("Teacher Not Found!!!!!");
          console.log("Teacher Not Found!!!!!");
        }
        res.json(row[0]);
        //  knex.destroy();
      })
      .catch((err) => {
        console.log(err);
        res.status(500);
      });
  },

  getAllTeachers: (res) => {
    knex
      .from("TEACHER")
      .select("*")
      .then((rows) => {
        if (!rows || rows.length == 0) {
          res.status(400);
          res.send("No Teacher Found");
        }
        res.json(rows);
        // knex.destroy();
      })
      .catch((err) => {
        console.log(err);
        res.status(500);
      });
  },
};
