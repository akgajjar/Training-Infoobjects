const express = require("express");
const app = express();
const bcrypt = require("bcrypt");
const passport = require("passport");
const flash = require("express-flash");
const session = require("express-session");
const methodOverride = require('method-override');

const initializePassport = require("./passportConfig");

initializePassport(
  passport,
  (email) => users.find((user) => user.email === email),
  (id) => users.find((user) => user.id === id)
);

app.set("app-engine", "ejs");
app.use(express.urlencoded({ extended: false }));
app.use(flash());
app.use(
  session({
    secret: "secret",
    resave: false,
    saveUninitialized: false,
  })
);
app.use(passport.initialize());
app.use(passport.session());
app.use(methodOverride('_method'))
const users = [];

app.get("/",checkAuthenticated,(req, res) => {
  res.render("index.ejs", { name: req.user.name });
});

app.delete('/logout')
app.get("/login",checkNotAuthenticated,(req, res) => {
  res.render("login.ejs");
});
app.get("/register",checkNotAuthenticated, (req, res) => {
  res.render("register.ejs");
});

app.post("/register", checkNotAuthenticated,async (req, res) => {
  try {
    const hashedPassword = await bcrypt.hash(req.body.password, 10);
    users.push({
      id: Date.now().toString(),
      name: req.body.name,
      email: req.body.email,
      password: hashedPassword,
    });
    res.redirect("/login");
  } catch {
    res.redirect("/register");
  }
  console.log(users);
});

app.post(
    "/login",
    checkNotAuthenticated,
  passport.authenticate("local", {
    successRedirect: "/",
    failureFlash: true,
    failureRedirect: "/login",
  })
);

app.delete('/logout', checkAuthenticated, (req, res) => {
    req.logOut();
    res.redirect('/login')
})


function checkAuthenticated(req, res, next) {
    if (req.isAuthenticated()) {
        return next();
    }
    res.redirect('/login');
}


function checkNotAuthenticated(req, res, next) {
  if (req.isAuthenticated()) {
     res.redirect("/");
  }
    return next();
 
}

app.listen(3000);
