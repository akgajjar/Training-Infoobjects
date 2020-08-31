var Ajv = require("ajv");

var data = {
  id: 64209690,
  name: "J",
  email: "jane.smith@gmail.com",
  phone: "07777 888 999",
  address: {
    street: "Flat 1, 188 High Street Kensington",
    postcode: "W8 5AA",
    city: "London",
    country: "United Kingdom",
  },
  personal: {
    DOB: "1982-08-16",
    age: 33,
    gender: "female",
  },
};
var schema = {
  //$schema: "https://json-schema.org/draft-04/schema#",
  title: "User",
  description: "User profile with connections",
    type: "object",
  required : ["name"],
  properties: {
    id: {
      description: "positive integer or string of digits",
      type: ["string", "integer"],
      pattern: "^[1-9][0-9]*$",
      minimum: 1,
    },
    name: { type: "string",minLength : 2, maxLength: 128 },
    email: { type: "string", format: "email" },
    phone: { type: "string", pattern: "^[0-9()-.s]+$" },
    address: {
      type: "object",
      additionalProperties: { type: "string" },
      maxProperties: 6,
      required: ["street", "postcode", "city", "country"],
    },
    personal: {
      type: "object",
      properties: {
        DOB: { type: "string", format: "date" },
        age: { type: "integer", minimum: 13 },
        gender: { enum: ["female", "male"] },
      },
      required: ["DOB", "age"],
      additionalProperties: false,
    },
  },
  errorMessage: {
    properties: {
      phone:
        "size should be a number bigger or equal to 4, current value is ${/size}",
    },
  },
};


var ajv = new Ajv({ allErrors: true, keepErrors: true }); // options can be passed, e.g. {allErrors: true}
var validate = ajv.compile(schema);
var valid = ajv.addSchema(schema, "mySchema").validate("mySchema", data);
if (!valid) console.log(validate.errors);
//
