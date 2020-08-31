const knex = require("../utils/knexPools/createKnexPGPool");
const epConfig = require("../epConfig.js");
const { reject } = require("lodash");
const knexConfig = epConfig.pgSqlConfig;

var empCrudService = {};

empCrudService.create = (employee, techIds) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee")
			.returning("*")
			.insert(employee)
			.then((insertedEmployee) => {
				console.log(
					"Employee Inserted : " + JSON.stringify(insertedEmployee)
				);

				let employeeTechnologies = [];
				for (let Tech_Id of techIds) {
					employeeTechnologies.push({
						Emp_Id: insertedEmployee[0].Emp_Id,
						Tech_Id: Tech_Id,
					});
				}

				knex.withSchema(knexConfig.schema)
					.table("Employee_Technology")
					.returning("*")
					.insert(employeeTechnologies)
					.then((insertedEmployeeTechnologies) => {
						console.log(
							"EmployeeTechnologies Inserted : " +
								JSON.stringify(insertedEmployeeTechnologies)
						);
						insertedEmployee[0].Employee_Technologies = insertedEmployeeTechnologies;
						resolve(insertedEmployee[0]);
					})
					.catch(function (err) {
						console.log(
							"Error in executing knex query for Inserting EmployeeTechnologies" +
								err
						);
						reject(err);
					});
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Inserting Employee" + err
				);
				reject(err);
			});
	});
};

empCrudService.update = (employee, employeeTechnologies, empId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee")
			.returning("*")
			.where("Emp_Id", "=", empId)
			.update(employee)
			.then((updatedEmployee) => {
				console.log(
					"Employee Updated : " + JSON.stringify(updatedEmployee)
				);
				knex.withSchema(knexConfig.schema)
					.table("Employee_Technology")
					.returning("*")
					.where("Emp_Id", "=", empId)
					.delete()
					.then((deleteEmployeeTechnologies) => {
						console.log(
							"Emoloyee Technology Deleted  : " +
								deleteEmployeeTechnologies
						);
						knex.withSchema(knexConfig.schema)
							.table("Employee_Technology")
							.returning("*")
							.insert(employeeTechnologies)
							.then((insertedEmployeeTechnologies) => {
								console.log(
									"EmployeeTechnologies Inserted : " +
										JSON.stringify(
											insertedEmployeeTechnologies
										)
								);
								updatedEmployee[0].Employee_Technologies = insertedEmployeeTechnologies;
								resolve(updatedEmployee[0]);
							})
							.catch(function (err) {
								console.log(
									"Error in executing knex query for Inserting EmployeeTechnologies" +
										err
								);
								reject(err);
							});
					})
					.catch((err) => {
						console.log(err);
						reject(err);
					});
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Updating Employee" + err
				);
				reject(err);
			});
	});
};

empCrudService.remove = (empId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.returning("*")
			.where("Emp_Id", "=", empId)
			.delete()
			.then((deletedEmployeeTechnology) => {
				knex.withSchema(knexConfig.schema)
					.table("Employee")
					.returning("*")
					.where("Emp_Id", "=", empId)
					.delete()
					.then((deletedEmployee) => {
						if (deletedEmployee)
							deletedEmployee[0].Deleted_Employee_Technology = deletedEmployeeTechnology;
						console.log(
							"Employee Deleted : " +
								JSON.stringify(deletedEmployee[0])
						);
						resolve(deletedEmployee[0]);
					})
					.catch(function (err) {
						console.log(
							"Error in executing knex query for Deleting Employee" +
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
			});
	});
};

empCrudService.list = () => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee")
			.select("*")
			.then((employees) => {
				let promises = [];
				for (employee of employees) {
					promises.push(empCrudService.get(employee.Emp_Id));
				}
				Promise.all(promises)
					.then((selectedEmployees) => {
						console.log(
							"Selected Employees : " +
								JSON.stringify(selectedEmployees)
						);
						resolve(selectedEmployees);
					})
					.catch((err) => {
						console.log(
							"Error in executing knex query for Selecting Employees" +
								err
						);
						reject(err);
					});
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting Employees" +
						err
				);
				reject(err);
			});
	});
};

empCrudService.get = (empId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee")
			.where("Emp_Id", "=", empId)
			.select("*")
			.then((selectedEmployee) => {
				if (selectedEmployee) {
					empCrudService
						.getEmployeeTechnology(empId)
						.then((selectedEmployeeTechnologies) => {
							selectedEmployee[0].Selected_Employee_Technologies = selectedEmployeeTechnologies;
							console.log(
								"Employee Selected : " +
									JSON.stringify(selectedEmployee)
							);
							resolve(selectedEmployee[0]);
						})
						.catch((err) => reject(err));
				} else {
					console.log(
						"Employee Selected : " +
							JSON.stringify(selectedEmployee)
					);
					resolve(selectedEmployee);
				}
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting Employee" + err
				);
				reject(err);
			});
	});
};

empCrudService.getEmployeeTechnology = (empId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.where("Emp_Id", "=", empId)
			.select("*")
			.then((selectedEmployeeTechnologies) => {
				resolve(selectedEmployeeTechnologies);
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting Employee Technologies" +
						err
				);
				reject(err);
			});
	});
};

empCrudService.getByTechId = (techId) => {
	return new Promise((resolve, reject) => {
		knex.withSchema(knexConfig.schema)
			.table("Employee_Technology")
			.where("Tech_Id", "=", techId)
			.select("*")
			.then((empTechnologies) => {
				console.log(
					"Employee_Technologies Selected : " +
						JSON.stringify(empTechnologies)
				);

				let promises = [];
				for (let Emp_Technology of empTechnologies) {
					promises.push(empCrudService.get(Emp_Technology.Emp_Id));
				}

				 Promise.all(promises)
					.then((employees) => {
						console.log("Employees Selected : " + employees);
						resolve(employees);
					})
					.catch((err) => {
						console.log(
							"Error in executing knex query for Selecting Employees by Tech Id" +
								err
						);
						reject(err);
					});
			})
			.catch(function (err) {
				console.log(
					"Error in executing knex query for Selecting Employees by Tech Id" +
						err
				);
				reject(err);
			});
	});
};

module.exports = empCrudService;
