const LocalStreategy = require("passport-local").Strategy;
const bcrypt = require("bcrypt");
const passport = require("passport");

function initialize(passport, getUserByEmail, getUserById) {
  const authenticateUser = (email, password, done) => {
    return new Promise((resolve, reject) => {
      const user = getUserByEmail(email);
      if (user == null)
        resolve(done(null, false, { message: "No use with that email" }));

      bcrypt
        .compare(password, user.password)
        .then((bool) => {
          if (bool) resolve(done(null, user));
          else resolve(done(null, false, { message: "password is incorrect" }));
        })
        .catch((err) => {
          resolve(done(e));
        });
    });
  };
  passport.use(
    new LocalStreategy({ usernameField: "email" }, authenticateUser)
  );

  passport.serializeUser((user, done) => {
    done(null, user.id);
  });

  passport.deserializeUser((id, done) => {
    done(null, getUserById(id));
  });
}

module.exports = initialize;
