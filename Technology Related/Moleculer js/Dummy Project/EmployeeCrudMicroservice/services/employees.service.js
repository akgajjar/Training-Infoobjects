"use strict";

const { MoleculerClientError } = require("moleculer").Errors;
const empController = require("../controller/employeeController.js");
const validationMixins = require("../utils/validations.utility.js");
/**
 * employees service
 */
module.exports = {
	name: "employees",

	/**
	 * Service settings
	 */
	settings: {
		validator: true,
	},

	mixins: [validationMixins],

	/**
	 * Service metadata
	 */
	metadata: {},

	/**
	 * Service dependencies
	 */
	dependencies: [],

	hooks: {
		before: {
			"*": [
				"checkFname",
				"checkMname",
				"checkLname",
				"checkMobileNo",
				"checkEmailId",
				"checkId",
				"checkTechId",
				"checkTechIds",
				"checkEmployees",
			],
		},
	},

	/**
	 * Actions
	 */
	actions: {
		create: {
			// Parameters definitions to validator
			params: {
				Emp_Fname: { type: "string", min: 2, max: 15 },
				Emp_Mname: { type: "string", min: 2, max: 15 },
				Emp_Lname: { type: "string", min: 2, max: 15 },
				Emp_Mobile_No: { type: "string" },
				Emp_Email_Id: { type: "string", max: 50 },
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						empController
							.create(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Create Employee.",
										err.code,
										"employeeAPI",
										err
									)
								);
							});
				});
			},
		},

		update: {
			// Parameters definitions to validator
			params: {
				id: { type: "string" },
				Emp_Fname: { type: "string", min: 2, max: 15 },
				Emp_Mname: { type: "string", min: 2, max: 15 },
				Emp_Lname: { type: "string", min: 2, max: 15 },
				Emp_Mobile_No: { type: "string" },
				Emp_Email_Id: { type: "string", max: 50 },
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						empController
							.update(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Update Employee.",
										err.code,
										"employeeAPI",
										err
									)
								);
							});
				});
			},
		},

		remove: {
			// Parameters definitions to validator
			params: {
				id: { type: "string" },
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						empController
							.remove(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Delete Employee.",
										err.code,
										"employeeAPI",
										err
									)
								);
							});
				});
			},
		},

		list(ctx) {
			return new Promise((resolve, reject) => {
				if (ctx.locals.errors) resolve(ctx.locals.errors);
				else
					empController
						.list()
						.then((res) => {
							resolve(res);
						})
						.catch((err) => {
							reject(
								new MoleculerClientError(
									"Error in List Employees.",
									err.code,
									"employeeAPI",
									err
								)
							);
						});
			});
		},

		get: {
			// Parameters definitions to validator
			params: {
				id: { type: "string" },
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						empController
							.get(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Get Employee.",
										err.code,
										"employeeAPI",
										err
									)
								);
							});
				});
			},
		},

		getByTechId: {
			// Parameters definitions to validator
			params: {
				Tech_Id: { type: "string" },
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						empController
							.getByTechId(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								console.log(err);
								reject(
									new MoleculerClientError(
										"Error in Get Employees By Tech Id.",
										err.code,
										"employeeAPI",
										err
									)
								);
							});
				});
			},
		},

		bulkCreate: {
			// Parameters definitions to validator
			params: {
				Employees: {
					type: "array",
					items: {
						type: "object",
						props: {
							Emp_Fname: { type: "string", min: 2, max: 15 },
							Emp_Mname: { type: "string", min: 2, max: 15 },
							Emp_Lname: { type: "string", min: 2, max: 15 },
							Emp_Mobile_No: { type: "string" },
							Emp_Email_Id: { type: "string", max: 50 },
						},
					},
				},
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						empController
							.bulkCreate(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Create Employee.",
										err.code,
										"employeeAPI",
										err
									)
								);
							});
				});
			},
		},

		bulkUpdate: {
			// Parameters definitions to validator
			params: {
				Employees: {
					type: "array",
					items: {
						type: "object",
						props: {
							Emp_Fname: { type: "string", min: 2, max: 15 },
							Emp_Mname: { type: "string", min: 2, max: 15 },
							Emp_Lname: { type: "string", min: 2, max: 15 },
							Emp_Mobile_No: { type: "string" },
							Emp_Email_Id: { type: "string", max: 50 },
						},
					},
				},
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						empController
							.bulkUpdate(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Create Employee.",
										err.code,
										"employeeAPI",
										err
									)
								);
							});
				});
			},
		},
	},

	/**
	 * Events
	 */
	events: {},

	/**
	 * Methods
	 */
	methods: {},

	/**
	 * Service created lifecycle event handler
	 */
	created() {},

	/**
	 * Service started lifecycle event handler
	 */
	async started() {},

	/**
	 * Service stopped lifecycle event handler
	 */
	async stopped() {},
};
