const techService = require("../common/technologyCrudService.js");

var techController = {};

techController.create = (ctx) => {
	return new Promise((resolve, reject) => {
		const technology = {
			Tech_Name: ctx.params.Tech_Name,
			Tech_Description: ctx.params.Tech_Name,
		};
		techService
			.create(technology)
			.then((insertedTechnology) =>
				resolve({
					Inserted_Technology: insertedTechnology,
					Message: "Technology is Successfully Inserted",
				})
			)
			.catch((err) => reject(err));
	});
};

techController.update = (ctx) => {
	return new Promise((resolve, reject) => {
		const technology = {
			Tech_Name: ctx.params.Tech_Name,
			Tech_Description: ctx.params.Tech_Description,
		};
		techService
			.update(technology, ctx.params.id)
			.then((updatedTechnology) =>
				resolve({
					Updated_Technology: updatedTechnology,
					Message: "Technology is Successfully Updated",
				})
			)
			.catch((err) => reject(err));
	});
};

techController.remove = (ctx) => {
	return new Promise((resolve, reject) => {
		techService
			.remove(ctx.params.id)
			.then((deletedTechnology) =>
				resolve({
					Deleted_Technology: deletedTechnology,
					Message: "Technology is Successfully Deleted",
				})
			)
			.catch((err) => reject(err));
	});
};

techController.list = () => {
	return new Promise((resolve, reject) => {
		techService
			.list()
			.then((technologies) =>
				resolve({
					Technologies: technologies,
					Message: "Technologies is Successfully Selected",
				})
			)
			.catch((err) => reject(err));
	});
};

techController.get = (ctx) => {
	return new Promise((resolve, reject) => {
		techService
			.get(ctx.params.id)
			.then((technology) =>
				resolve({
					Technology: technology,
					Message: "Technology is Successfully Selected",
				})
			)
			.catch((err) => reject(err));
	});
};

techController.getByEmpId = (ctx) => {

	return new Promise((resolve, reject) => {
		techService
			.getTechnologyByEmpIds(ctx.params.Emp_Id)
			.then((technologies) =>
				resolve({
					Technologies: technologies,
					Message: "Technologies is Successfully Selected",
				})
			)
			.catch((err) => reject(err));
	});
};

module.exports = techController;
