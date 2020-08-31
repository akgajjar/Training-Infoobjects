const knex = require("../utils/knexPools/createKnexPGPool");
const epConfig = require("../epConfig.js");
const knexConfig = epConfig.pgSqlConfig;

var techCrudService = {};

techCrudService.create = (technology) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Technology")
			.returning("*")
			.insert(technology)
			.then((insertedTechnology) => {
				console.log(
					"Technology Inserted : " +
						JSON.stringify(insertedTechnology)
				);
				resolve(insertedTechnology);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Inserting Technology" +
						err
				);
				reject(err);
			});
	});
};

techCrudService.update = (technology, techId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Technology")
			.returning("*")
			.where("Tech_Id", "=", techId)
			.update(technology)
			.then((updatedTechnology) => {
				console.log(
					"Technology Updated : " + JSON.stringify(updatedTechnology)
				);
				resolve(updatedTechnology);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Updating Technology" +
						err
				);
				reject(err);
			});
	});
};

techCrudService.remove = (techId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.returning("*")
			.where("Tech_Id", "=", techId)
			.delete()
			.then((deletedEmployeeTechnology) => {
				knex.withSchema(knexConfig.schema)
					.table("Technology")
					.returning("*")
					.where("Tech_Id", "=", techId)
					.delete()
					.then((deletedTechnology) => {
						if (deletedTechnology)
							deletedTechnology[0].Deleted_Employee_Technology = deletedEmployeeTechnology;
						console.log(
							"Technology Deleted : " +
								JSON.stringify(deletedTechnology[0])
						);
						resolve(deletedTechnology[0]);
					})
					.catch(function (err) {
						console.log(
							"Error in executing knex query for Deleting Technology" +
								err
						);
						reject(err);
					});
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Deleting EmployeeTechnology" +
						err
				);
				reject(err);
			});
	});
};

techCrudService.list = () => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Technology")
			.returning("*")
			.select()
			.then((technologies) => {
				console.log(
					"Technologies Selected : " + JSON.stringify(technologies)
				);
				resolve(technologies);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting Technologies" +
						err
				);
				reject(err);
			});
	});
};

techCrudService.get = (techId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Technology")
			.returning("*")
			.where("Tech_Id", "=", techId)
			.select()
			.then((technology) => {
				console.log(
					"Technology Selected : " + JSON.stringify(technology)
				);
				resolve(technology);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting Technology" +
						err
				);
				reject(err);
			});
	});
};

techCrudService.getTechnologyByEmpIds = (empId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.where("Emp_Id", "=", empId)
			.select("*")
			.then((employeeTechnologies) => {
				console.log(
					"Employee_Technolgy Ids Selected : " +
						JSON.stringify(employeeTechnologies)
				);
				let promises = [];
				for (let employeeTechnology of employeeTechnologies) {
					promises.push(
						techCrudService.get(employeeTechnology.Tech_Id)
					);
				}

				Promise.all(promises)
					.then((technologies) => {
						console.log(
							"Technologies Selected By Emp Id: " +
								JSON.stringify(technologies)
						);
						resolve(technologies);
					})
					.catch((err) => {
						console.log(
							"Error in executing knex query for Selecting Technolgy Ids" +
								err
						);
						reject(err);
					});
			})
			.catch((err) => {
				console.log(
					"Error in executing knex query for Selecting Technolgy Ids" +
						err
				);
				reject(err);
			});
	});
};

module.exports = techCrudService;
