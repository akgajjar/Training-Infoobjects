const empTechService = require("../common/employeeTechnologyService.js");
const { reject } = require("lodash");

var empTechController = {};

empTechController.create = (ctx) => {
	return new Promise((resolve, reject) => {
		const employeeTechnology = {
			Tech_Id: ctx.params.Tech_Id,
			Emp_Id: ctx.params.Emp_Id,
		};

		empTechService
			.create(employeeTechnology)
			.then((insertedEmployeeTechnology) => {
				if (insertedEmployeeTechnology != null)
					resolve({
						Inserted_Employee_Technology:
							insertedEmployeeTechnology[0],
						Message: "EmployeeTechnology is Successfully Inserted",
					});
				resolve({
					Inserted_Employee_Technology: insertedEmployeeTechnology,
					Message: "Error While Inserting EmployeeTechnology",
				});
			})
			.catch((err) => {
				console.log(err);
				resolve({
					Inserted_Employee_Technology: null,
					Message: "Error While Inserting EmployeeTechnology",
				});
			});
	});
};

empTechController.update = (ctx) => {
	return new Promise((resolve, reject) => {
		const oldEmployeeTechnology = {
			Tech_Id: ctx.params.oldEmployeeTechnology.Tech_Id,
			Emp_Id: ctx.params.oldEmployeeTechnology.Emp_Id,
		};
		const newEmployeeTechnology = {
			Tech_Id: ctx.params.newEmployeeTechnology.Tech_Id,
			Emp_Id: ctx.params.newEmployeeTechnology.Emp_Id,
		};
		empTechService
			.update(oldEmployeeTechnology, newEmployeeTechnology)
			.then((updatedEmployeeTechnology) =>
				resolve({
					Updated_Employee_Technology: updatedEmployeeTechnology,
					Message: "EmployeeTechnology is Successfully Updated",
				})
			)
			.catch((err) => reject(err));
	});
};

empTechController.remove = (ctx) => {
	return new Promise((resolve, reject) => {
		const employeeTechnology = {
			Tech_Id: ctx.params.Tech_Id,
			Emp_Id: ctx.params.Emp_Id,
		};
		empTechService
			.remove(employeeTechnology)
			.then((deletedEmployeeTechnology) =>
				resolve({
					Deleted_Employee_Technology: deletedEmployeeTechnology,
					Message: "Technology is Successfully Deleted",
				})
			)
			.catch((err) => reject(err));
	});
};

empTechController.list = () => {
	return new Promise((resolve, reject) => {
		empTechService
			.list()
			.then((employeeTechnologies) =>
				resolve({
					Employee_Technologies: employeeTechnologies,
					Message: "EmployeeTechnologies is Successfully Selected",
				})
			)
			.catch((err) => reject(err));
	});
};

empTechController.getEmpIds =  (ctx) => {
	return new Promise((resolve, reject) => {
		empTechService.getEmpIds(ctx.params.Tech_Id)
			.then(employeeIds => resolve({
				Employee_Ids: employeeIds,
				Message: "Employee Ids is Successfully Selected",
			}))
			.catch(err => reject(err));
	})
};

empTechController.getTechIds = async (ctx) => {
	return new Promise((resolve, reject) => {
		empTechService.getTechIds(ctx.params.Emp_Id)
			.then(technologyIds => resolve({
			Technology_Ids: technologyIds,
			Message: "Technology Ids is Successfully Selected",
		})).catch(err => reject(err));
	})
};

module.exports = empTechController;
