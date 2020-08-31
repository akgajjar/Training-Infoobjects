"use strict";

const { MoleculerClientError } = require("moleculer").Errors;
const techController = require("../controller/technologyController.js");
const validationMixins = require("../utils/validations.utility.js");

/**
 * technologies service
 */
module.exports = {
	name: "technologies",

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
			"*": ["checkTechName", "checkId", "checkEmpId"],
		},
	},

	/**
	 * Actions
	 */
	actions: {
		create: {
			// Parameters definitions to validator
			params: {
				Tech_Name: { type: "string", max: 50 },
				Tech_Description: { type: "string", max: 255 },
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						techController
							.create(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Create Technology.",
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
				Tech_Name: { type: "string", max: 50 },
				Tech_Description: { type: "string", max: 255 },
			},
			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						techController
							.update(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Update Technology.",
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
						techController
							.remove(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Delete Technology.",
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
					techController
						.list()
						.then((res) => {
							resolve(res);
						})
						.catch((err) => {
							reject(
								new MoleculerClientError(
									"Error in List Technologies.",
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
						techController
							.get(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Get Technology.",
										err.code,
										"employeeAPI",
										err
									)
								);
							});
				});
			},
		},

		getByEmpId: {
			// Parameters definitions to validator
			params: {
				Emp_Id: { type: "string" },
			},

			handler(ctx) {
				return new Promise((resolve, reject) => {
					if (ctx.locals.errors) resolve(ctx.locals.errors);
					else
						techController
							.getByEmpId(ctx)
							.then((res) => {
								resolve(res);
							})
							.catch((err) => {
								reject(
									new MoleculerClientError(
										"Error in Get Technologies By Emp Id.",
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
