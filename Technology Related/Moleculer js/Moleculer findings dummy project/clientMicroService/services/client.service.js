"use strict";

/**
 * client service
 */
module.exports = {
	name: "client",
	circuitBreaker: {
		enabled: true,
		threshold: 0.5,
		minRequestCount: 20,
		windowTime: 60, // in seconds
		halfOpenTime: 5 * 1000, // in milliseconds
		check: (err) => err && err.code >= 500,
	},
	requestTimeout: 10 * 1000 // in milliseconds
	,
	/**
	 * Actions
	 */
	actions: {
		/**
		 * Say a 'add' action.
		 *
		 * @returns
		 */
		add: {
			rest: {
				method: "GET",
				path: "/add",
			},
			params: {
				number1: "string",
				number2: "string",
			},
			async handler(ctx) {
				//this.logger.info("message");

				return await ctx.call("calculator.add", {
					number1: Number(ctx.params.number1),
					number2: Number(ctx.params.number2),
				});
			},
		},
		/**
		 * Say a 'sub' action.
		 *
		 * @returns
		 */
		sub: {
			rest: {
				method: "GET",
				path: "/sub",
			},
			params: {
				number1: "string",
				number2: "string",
			},
			async handler(ctx) {
				return await ctx.call("calculator.sub", {
					number1: Number(ctx.params.number1),
					number2: Number(ctx.params.number2),
				});
			},
		},
		/**
		 * Say a 'multi' action.
		 *
		 * @returns
		 */
		multi: {
			rest: {
				method: "GET",
				path: "/multi",
			},
			params: {
				number1: "string",
				number2: "string",
			},
			async handler(ctx) {
				return await ctx.call("calculator.multi", {
					number1: Number(ctx.params.number1),
					number2: Number(ctx.params.number2),
				});
			},
		},
		/**
		 * Say a 'div' action.
		 *
		 * @returns
		 */
		div: {
			rest: {
				method: "GET",
				path: "/div",
			},
			params: {
				number1: "string",
				number2: "string",
			},
			async handler(ctx) {
				return await ctx.call("calculator.div", {
					number1: Number(ctx.params.number1),
					number2: Number(ctx.params.number2),
				});
			},
		},
	},
};
