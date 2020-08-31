"use strict";

/**
 * helper service
 */
module.exports = {
	name: "helper",

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
		/**
		 * Say a 'Random' action.
		 *
		 * @returns
		 */
		random: {
			name:"random",
			rest: {
				method: "GET",
				path: "/random",
			},

			async handler(ctx) {
				return Math.round(Math.random() * 10) + 1;
			},
		},
		/**
		 * Test action
		 */
		test: {
			async handler(ctx) {
				return "Hello Moleculer";
			},
		},
	},

	/**
	 * Events
	 */
	events: {
		async "some.thing"(ctx) {
			this.logger.info("Something happened", ctx.params);
		},
		"helper.called"(payload) {
			this.logger.info("Helper Service Caught an Event ");
			this.logger.info(payload);
		},
	},

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
