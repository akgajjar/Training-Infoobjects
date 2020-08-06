//productService.js
const { ServiceBroker, Service } = require("moleculer");
const HTTPServer = require("moleculer-web");




//create the Brocker for node-2
// Define nodeID and set the communcation bus 
"use strict";


const brockerProducts = new ServiceBroker({
    nodeID: "node-2",
    transporter: "NATS"
});


//create Gateway Service 
brockerProducts.createService({
    //define Service Name 
    name: "products",

    actions:{
        // Define Service Action that returns the available Products
        /* istProducts(ctx){
            returns [
                {name : "Apples", price : 5},
                {name : "Bananas", price : 2},
                {name : "Oranges", price : 3}
            ];
        }, */
        /**
		 * Say a 'Hello' action.
		 *
		 * @param {Context} ctx
		 * @returns
		 */
		listProducts: {
			name: "listProducts",
			rest: {
				method: "GET",
				path: "/listProducts",
			},

			async handler(ctx) {
				
				return [{name : "Apples", price : 5},
                {name : "Bananas", price : 2},
                {name : "Oranges", price : 3}];
			},
         }
    }
});

brockerProducts
  .start()
  .catch((err) => console.log(`Error Occured!!!!! ${err.message}`));
        


