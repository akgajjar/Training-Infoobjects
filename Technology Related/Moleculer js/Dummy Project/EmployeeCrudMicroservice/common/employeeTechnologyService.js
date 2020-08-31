const knex = require("../utils/knexPools/createKnexPGPool");
const epConfig = require("../epConfig.js");
const knexConfig = epConfig.pgSqlConfig;

var empTechCrudService = {};

empTechCrudService.create = (employeeTechnology) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.returning("*")
			.insert(employeeTechnology)
			.then((insertedEmployeeTechnology) => {
				console.log(
					"EmployeeTechnology Inserted : " +
						JSON.stringify(insertedEmployeeTechnology)
				);
				resolve(insertedEmployeeTechnology);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Inserting EmployeeTechnology" +
						err
				);
				resolve(null);
			});
	});
};

empTechCrudService.update = (oldEmployeeTechnology, newEmployeeTechnology) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.returning("*")
			.where("Emp_Id", "=", oldEmployeeTechnology.Emp_Id)
			.where("Tech_Id", "=", oldEmployeeTechnology.Tech_Id)
			.update(newEmployeeTechnology)
			.then((updatedEmployeeTechnology) => {
				console.log(
					"EmployeeTechnology Updated : " +
						JSON.stringify(updatedEmployeeTechnology)
				);
				resolve(updatedEmployeeTechnology);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Updating EmployeeTechnology" +
						err
				);
				reject(err);
			});
	});
};

empTechCrudService.remove = (employeeTechnology) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.returning("*")
			.where("Emp_Id", "=", employeeTechnology.Emp_Id)
			.where("Tech_Id", "=", employeeTechnology.Tech_Id)
			.delete()
			.then((deletedEmployeeTechnology) => {
				console.log(
					"EmployeeTechnology Deleted : " +
						JSON.stringify(deletedEmployeeTechnology)
				);
				resolve(deletedEmployeeTechnology);
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

empTechCrudService.list = () => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.select("*")
			.then((employeeTechnologies) => {
				console.log(
					"EmployeeTechnologies Selected : " +
						JSON.stringify(employeeTechnologies)
				);
				resolve(employeeTechnologies);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting EmployeeTechnologies" +
						err
				);
				reject(err);
			});
	});
};

empTechCrudService.getEmpIds = (techId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.where("Tech_Id", "=", techId)
			.select("Emp_Id")
			.then((empIds) => {
				console.log(
					"Employee Ids Selected : " + JSON.stringify(empIds)
				);
				resolve(empIds);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting Employee Ids" +
						err
				);
				reject(err);
			});
	});
};

empTechCrudService.getTechIds =  (empId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.where("Emp_Id", "=", empId)
			.select("Tech_Id")
			.then((techIds) => {
				console.log(
					"Technolgy Ids Selected : " + JSON.stringify(techIds)
				);
				resolve(techIds);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting Technolgy Ids" +
						err
				);
				reject(err);
			});
	});
};

module.exports = empTechCrudService;
