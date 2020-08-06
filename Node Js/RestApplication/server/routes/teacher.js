//contains  all teacher related routes
const express = require("express");
const router = express.Router();
const teacherDAO = require("../DAO/teacherDAO.js");

const bodyParser = require("body-parser");

router.use(bodyParser.urlencoded({ extended: true }));

router.get("/api/teacher/:id", (req, res) => {
  teacherDAO.findTeacherById(req.params.id, res);
});

router.get("/api/teacher", (req, res) => {
  teacherDAO.getAllTeachers(res);
});

router.post("/api/teacher", (req, res) => {
  const teacher = {
    TEACHER_NAME: req.body.TEACHER_NAME,
    TEACHER_ADDRESS: req.body.TEACHER_ADDRESS,
    TEACHER_DESIGNATION: req.body.TEACHER_DESIGNATION,
    TEACHER_EMAIL_ID: req.body.TEACHER_EMAIL_ID,
    TEACHER_MOBILE: req.body.TEACHER_MOBILE,
    TEACHER_SALARY: Number(req.body.TEACHER_SALARY),
  };

  teacherDAO.insertTeacher(teacher);
  res.send("Teacher Inserted Successfully");

  res.end();
});

router.put("/api/teacher", (req, res) => {
  res.send("update Teacher");
});

router.delete("/api/teacher/:id", (req, res) => {
  res.send("delete Teacher");
});

module.exports = router;
