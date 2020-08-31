"use strict";
const { MoleculerClientError } = require("moleculer").Errors;
const empTechController = require("../controller/employeeTechnologyController.js");

/**
 * employeeTechnologies service
 */
module.exports = {
	name: "employeeTechnologies",

	/**
	 * Service settings
	 */
	settings: {},

	/**
	 * Service metadata
	 */
	metadata: {},

	/**
	 * Service dependencies
	 */
	dependencies: [],

	/**
	 * Actions
	 */
	actions: {
		create(ctx) {
			return new Promise((resolve, reject) => {
				if (ctx.locals.errors) resolve(ctx.locals.errors);
				else
					empTechController
						.create(ctx)
						.then((res) => {
							resolve(res);
						})
						.catch((err) => {
							reject(
								new MoleculerClientError(
									"Error in Create EmployeeTechnology.",
									err.code,
									"employeeAPI",
									err
								)
							);
						});
			});
		},

		update(ctx) {
			return new Promise((resolve, reject) => {
				if (ctx.locals.errors) resolve(ctx.locals.errors);
				else
					empTechController
						.update(ctx)
						.then((res) => {
							resolve(res);
						})
						.catch((err) => {
							reject(
								new MoleculerClientError(
									"Error in Update EmployeeTechnology.",
									err.code,
									"employeeAPI",
									err
								)
							);
						});
			});
		},

		remove(ctx) {
			return new Promise((resolve, reject) => {
				if (ctx.locals.errors) resolve(ctx.locals.errors);
				else
					empTechController
						.remove(ctx)
						.then((res) => {
							resolve(res);
						})
						.catch((err) => {
							reject(
								new MoleculerClientError(
									"Error in Delete EmployeeTechnology.",
									err.code,
									"employeeAPI",
									err
								)
							);
						});
			});
		},

		list(ctx) {
			return new Promise((resolve, reject) => {
				if (ctx.locals.errors) resolve(ctx.locals.errors);
				else
					empTechController
						.list()
						.then((res) => {
							resolve(res);
						})
						.catch((err) => {
							reject(
								new MoleculerClientError(
									"Error in List EmployeeTechnologies.",
									err.code,
									"employeeAPI",
									err
								)
							);
						});
			});
		},

		getEmpIds(ctx) {
			if (ctx.locals.errors) resolve(ctx.locals.errors);
			else
				return new Promise((resolve, reject) => {
					empTechController
						.getEmpIds(ctx)
						.then((res) => {
							resolve(res);
						})
						.catch((err) => {
							reject(
								new MoleculerClientError(
									"Error in Get Employee Ids.",
									err.code,
									"employeeAPI",
									err
								)
							);
						});
				});
		},

		getTechIds(ctx) {
			if (ctx.locals.errors) resolve(ctx.locals.errors);
			else
				return new Promise((resolve, reject) => {
					empTechController
						.getTechIds(ctx)
						.then((res) => {
							resolve(res);
						})
						.catch((err) => {
							reject(
								new MoleculerClientError(
									"Error in Get Technology Ids.",
									err.code,
									"employeeAPI",
									err
								)
							);
						});
				});
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
