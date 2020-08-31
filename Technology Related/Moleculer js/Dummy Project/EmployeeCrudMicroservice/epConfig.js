module.exports = {
	environment: "DEV",
	enablePgToken: true,
	env: {
		hostName: "localhost",
		ipAddr: "127.0.0.1",
		port: "8765",
		protocol: "http",
	},
	pgSqlConfig: {
		host: "localhost",
		user: "postgres",
		database: "postgres",
		password: "postgres",
		port: 5432,
		schema: "EmployeeSchema",
		minPool: 1,
		maxPool: 10,
		acquireConnectionTimeout: 10000,
	},
	eureka: {
		protocol: "http",
		host: "localhost",
		port: 8761,
		servicePath: "/eureka/apps/",
	},
};
