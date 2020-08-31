"use strict";

/**
 * calculator service
 */
module.exports = {
	name: "calculator",

	circuitBreaker: {
		enabled: true,
		threshold: 0.5,
		minRequestCount: 20,
		windowTime: 60, // in seconds
		halfOpenTime: 5 * 1000, // in milliseconds
		check: (err) => err && err.code >= 500,
	},
	requestTimeout: 10 * 1000, // in milliseconds
	
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
				number1: "number",
				number2: "number",
			},
			async handler(ctx) {
				return ctx.params.number1 + ctx.params.number2;
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
				number1: "number",
				number2: "number",
			},
			async handler(ctx) {
				return ctx.params.number1 - ctx.params.number2;
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
				number1: "number",
				number2: "number",
			},
			async handler(ctx) {
				return ctx.params.number1 * ctx.params.number2;
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
				number1: "number",
				number2: "number",
			},
			async handler(ctx) {
				return ctx.params.number1 / ctx.params.number2;
			},
		},
	},
};
