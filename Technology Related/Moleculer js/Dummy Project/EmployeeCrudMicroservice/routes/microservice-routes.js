const _ = require("lodash");

module.exports = [
	{
		path: "/api",

		aliases: {
			// routes
			"REST employees": "employees",
			"REST technologies": "technologies",
			"POST employees/bulkCreate": "employees.bulkCreate",
			"PUT employees/bulkUpdate": "employees.bulkUpdate",
			"GET employees/getByTechId": "employees.getByTechId",
			"GET technologies/getByEmpId": "technologies.getByEmpId",
		},

		// Disable to call not-mapped actions
		mappingPolicy: "restrict",

		// Enable/disable parameter merging method. More info: https://moleculer.services/docs/0.14/moleculer-web.html#Disable-merging
		mergeParams: true,

		// The auto-alias feature allows you to declare your route alias directly in your services.
		// The gateway will dynamically build the full routes from service schema.
		autoAliases: false,

		// Disable to call not-mapped actions
		mappingPolicy: "restrict",

		// Set CORS headers
		cors: true,

		// Enable/disable logging
		logging: true,

		// Parse body content
		bodyParser: {
			json: {
				limit: "500mb",
				strict: false,
			},
			urlencoded: {
				limit: "500mb",
				extended: true,
			},
		},
		onError(req, res, err) {
			res.setHeader("Content-type", "application/json; charset=utf-8");
			res.writeHead(err.code || 500);
			const errJson = {
				message: err.message,
				code: err.code,
				type: err.type,
				data: err.data,
			};
			const response = JSON.stringify(errJson, null, 2);
			res.end(response);
		},
	},
];
