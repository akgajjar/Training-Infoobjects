const { MoleculerClientError } = require("moleculer").Errors;

module.exports = {
	methods: {
		checkFname(ctx) {
			if (ctx.params.Emp_Fname != null)
				this.validate(
					ctx,
					ctx.params.Emp_Fname,
					"^[a-zA-Z ]+$",
					"stringOnly",
					"The 'Emp_Fname' field length must be Characters Only.",
					"Emp_Fname"
				);
		},

		checkMname(ctx) {
			if (ctx.params.Emp_Mname != null)
				this.validate(
					ctx,
					ctx.params.Emp_Mname,
					"^[a-zA-Z ]+$",
					"stringOnly",
					"The 'Emp_Mname' field length must be Characters Only.",
					"Emp_Mname"
				);
		},

		checkLname(ctx) {
			if (ctx.params.Emp_Lname != null)
				this.validate(
					ctx,
					ctx.params.Emp_Lname,
					"^[a-zA-Z ]+$",
					"stringOnly",
					"The 'Emp_Lname' field length must be Characters Only.",
					"Emp_Lname"
				);
		},

		checkMobileNo(ctx) {
			if (ctx.params.Emp_Mobile_No != null)
				this.validate(
					ctx,
					ctx.params.Emp_Mobile_No,
					/^[9876]\d{9}$/i,
					"Invalid Mobile No",
					"The 'Emp_Mobile_No' Is Not Valid.",
					"Emp_Mobile_No"
				);
		},

		checkEmailId(ctx) {
			if (ctx.params.Emp_Email_Id != null)
				this.validate(
					ctx,
					ctx.params.Emp_Email_Id,
					/^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\.[a-zA-Z.]{2,3}$/i,
					"Invalid Email Id",
					"The 'Emp_Email_Id' Is Not Valid.",
					"Emp_Email_Id"
				);
		},

		checkTechName(ctx) {
			if (ctx.params.Tech_Name != null)
				this.validate(
					ctx,
					ctx.params.Tech_Name,
					"^[a-zA-Z ]+$",
					"stringOnly",
					"The 'Tech_Name' field length must be Characters Only.",
					"Tech_Name"
				);
		},

		checkId(ctx) {
			if (ctx.params.id != null) {
				if (
					this.validate(
						ctx,
						ctx.params.id,
						"^[0-9]+$",
						"digitOnly",
						"The 'id' field must be Integer Only.",
						"id"
					)
				)
					ctx.params.id = Number(ctx.params.id);
			}
		},

		checkTechId(ctx) {
			if (ctx.params.Tech_Id != null) {
				if (
					this.validate(
						ctx,
						ctx.params.Tech_Id,
						"^[0-9]+$",
						"digitOnly",
						"The 'Tech_Id' field must be Integer Only.",
						"Tech_Id"
					)
				)
					ctx.params.Tech_Id = Number(ctx.params.Tech_Id);
			}
		},

		checkEmpId(ctx) {
			if (ctx.params.Emp_Id != null) {
				if (
					this.validate(
						ctx,
						ctx.params.Emp_Id,
						"^[0-9]+$",
						"digitOnly",
						"The 'Emp_Id' field must be Integer Only.",
						"Emp_Id"
					)
				)
					ctx.params.Emp_Id = Number(ctx.params.Emp_Id);
			}
		},

		checkTechIds(ctx) {
			if (ctx.params.Tech_Ids != null) {
				for (let Tech_Id of ctx.params.Tech_Ids) {
					if (
						!this.validate(
							ctx,
							Tech_Id,
							"^[0-9]+$",
							"digitOnly",
							"The 'Tech_Ids' field must be array of integers Only.",
							"Tech_Ids"
						)
					)
						return;
					ctx.params.Tech_Id = Number(ctx.params.Tech_Id);
				}
			}
		},

		checkEmployees(ctx) {
			if (ctx.params.Employees != null) {
				for (let employee of ctx.params.Employees) {
					if (employee.Emp_Id != null)
						this.validate(
							ctx,
							employee.Emp_Id,
							"^[0-9]+$",
							"digitOnly",
							"The 'Emp_Id' field must be Integer Only.",
							"Emp_Id"
						);

					this.validate(
						ctx,
						employee.Emp_Fname,
						"^[a-zA-Z ]+$",
						"stringOnly",
						"The 'Emp_Fname' field length must be Characters Only.",
						"Emp_Fname"
					);
					this.validate(
						ctx,
						employee.Emp_Mname,
						"^[a-zA-Z ]+$",
						"stringOnly",
						"The 'Emp_Mname' field length must be Characters Only.",
						"Emp_Mname"
					);
					this.validate(
						ctx,
						employee.Emp_Lname,
						"^[a-zA-Z ]+$",
						"stringOnly",
						"The 'Emp_Lname' field length must be Characters Only.",
						"Emp_Lname"
					);
					this.validate(
						ctx,
						employee.Emp_Mobile_No,
						/^[9876]\d{9}$/i,
						"Invalid Mobile No",
						"The 'Emp_Mobile_No' Is Not Valid.",
						"Emp_Mobile_No"
					);
					this.validate(
						ctx,
						employee.Emp_Email_Id,
						/^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\.[a-zA-Z.]{2,3}$/i,
						"Invalid Email Id",
						"The 'Emp_Email_Id' Is Not Valid.",
						"Emp_Email_Id"
					);
				}
			}
		},

		validate(ctx, value, regex, type, message, field) {
			if (!this.checkRegex(value, regex)) {
				const err = this.generateError(type, message, field);
				this.pushIntoLocals(ctx, err);
				return false;
			}
			return true;
		},

		checkRegex(value, regex) {
			if (value.match(regex)) return true;
			return false;
		},

		generateError(type, message, field) {
			return new MoleculerClientError(
				"Parameters validation error!",
				422,
				"VALIDATION_ERROR",
				[
					{
						type: type,
						message: message,
						field: field,
						nodeID: "EmployeeCrudMicroservice",
					},
				]
			);
		},

		pushIntoLocals(ctx, err) {
			if (ctx.locals.errors) {
				ctx.locals.errors.push(err);
				return;
			}
			ctx.locals.errors = [err];
		},
	},
};
