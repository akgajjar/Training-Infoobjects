const empService = require("../common/employeeCrudService.js");
const { compact, reject } = require("lodash");

var empController = {};

empController.create = (ctx) => {
	return new Promise((resolve, reject) => {
		let employee = null;
		let techIds = null;
		if (ctx.params.employee == null) {
			employee = {
				Emp_Fname: ctx.params.Emp_Fname,
				Emp_Mname: ctx.params.Emp_Mname,
				Emp_Lname: ctx.params.Emp_Lname,
				Emp_Mobile_No: ctx.params.Emp_Mobile_No,
				Emp_Email_Id: ctx.params.Emp_Email_Id,
			};
			techIds = ctx.params.Tech_Ids;
		} else {
			techIds = ctx.params.employee.Tech_Ids;
			employee = ctx.params.employee;
			delete employee.Tech_Ids;
		}
		empService
			.create(employee, techIds)
			.then((insertedEmployee) => {
				resolve({
					Inserted_Employee: insertedEmployee,
					Message: "Employee is Successfully Inserted",
				});
			})
			.catch((err) => reject(err));
	});
};

empController.update = (ctx) => {
	return new Promise((resolve, reject) => {
		let employee = null;
		let employeeTechnologies = null;
		let empId = null;
		if (ctx.params.employee == null) {
			employee = {
				Emp_Fname: ctx.params.Emp_Fname,
				Emp_Mname: ctx.params.Emp_Mname,
				Emp_Lname: ctx.params.Emp_Lname,
				Emp_Mobile_No: ctx.params.Emp_Mobile_No,
				Emp_Email_Id: ctx.params.Emp_Email_Id,
			};
			employeeTechnologies = ctx.params.Employee_Technologies;
			empId = ctx.params.id;
		} else {
			employeeTechnologies = ctx.params.employee.Employee_Technologies;
			employee = ctx.params.employee;
			empId = ctx.params.employee.Emp_Id;
			delete employee.Employee_Technologies;
			delete employee.Emp_Id;
		}
		console.log(empId);

		empService
			.update(employee, employeeTechnologies, empId)
			.then((updatedEmployee) => {
				resolve({
					Update_Employee: updatedEmployee,
					Message: "Employee is Successfully Updated",
				});
			})
			.catch((err) => {
				reject(err);
			});
	});
};

empController.remove = (ctx) => {
	return new Promise((resolve, reject) => {
		empService
			.remove(ctx.params.id)
			.then((deletedEmployee) => {
				resolve({
					Deleted_Employee: deletedEmployee,
					Message: "Employee is Successfully Deleted",
				});
			})
			.catch((err) => reject(err));
	});
};

empController.list = () => {
	return new Promise((resolve, reject) => {
		empService
			.list()
			.then((employees) => {
				resolve(
					(response = {
						Employees: employees,
						Message: "Employees is Successfully Selected",
					})
				);
			})
			.catch((err) => reject(err));
	});
};

empController.get = async (ctx) => {
	return new Promise((resolve, reject) => {
		empService
			.get(ctx.params.id)
			.then((selectedEmployee) => {
				resolve({
					Employee: selectedEmployee,
					Message: "Employee is Successfully Selected",
				});
			})
			.catch((err) => reject(err));
	});
};

empController.getByTechId = (ctx) => {
	return new Promise((resolve, reject) => {
		empService
			.getByTechId(ctx.params.Tech_Id)
			.then((employees) => {
				resolve(
					(response = {
						Employees: employees,
						Message: "Employees is Successfully Selected.",
					})
				);
			})
			.catch((err) => reject(err));
	});
};

empController.bulkCreate = (ctx) => {
	return new Promise((resolve, reject) => {
		let promises = [];
		for (let employee of ctx.params.Employees) {
			ctx.params.employee = employee;
			promises.push(empController.create(ctx));
		}

		Promise.all(promises)
			.then((insertedEmployees) => {
				resolve({
					Inserted_Employees: insertedEmployees,
					Message: "Employees is Successfully Inserted",
				});
			})
			.catch((err) => {
				reject(err);
			});
	});
};

empController.bulkUpdate = (ctx) => {
	return new Promise((resolve, reject) => {
		let promises = [];
		for (let employee of ctx.params.Employees) {
			ctx.params.employee = employee;
			promises.push(empController.update(ctx));
		}

		Promise.all(promises)
			.then((updatedEmployees) => {
				resolve({
					Updated_Employees: updatedEmployees,
					Message: "Employees is Successfully Updated",
				});
			})
			.catch((err) => {
				reject(err);
			});
	});
};

module.exports = empController;
