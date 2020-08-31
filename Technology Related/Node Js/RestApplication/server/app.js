const express = require("express");
const app = express();
const port = process.env.PORT || 3000;
const bodyParser = require("body-parser");
const teacherRoutes = require("./routes/teacher.js");
const studentRoutes = require("./routes/student.js");
const teacherStudentRoutes = require("./routes/teacherStudent.js");
const morgan = require("morgan");

app.use(morgan("short")); // we can use combined for detailed logs.
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static("./public"));
app.use(teacherRoutes);
app.use(studentRoutes);
app.use(teacherStudentRoutes);
/*
const courses = [
  { id: 1, name: "course1" },
  { id: 2, name: "course2" },
  { id: 3, name: "course3" },
];
app.get("/", (req, res) => {
  res.send("hello world");
});

app.get("/api/courses", (req, res) => {
  res.send(courses);
});

// /api/courses?sortBy=name
app.get("/api/courses", (req, res) => {
  res.send(req.query.sortBy);
});

// /api/courses/1
app.get("/api/courses/:id", (req, res) => {
  const course = course.find((c) => c.id === parseInt(req.params.id));
  if (!course)
    //404
    res.status(404).send("The course for given id is not found");
  else res.send(course);
});
*/

app.get("/", (req, res) => {
  console.log("responding to root route");
  res.send("hello from Rooooot");
});

app.listen(port, () => {
  console.log(`Server is up and listening on ${port}!!!!!!`);
});
