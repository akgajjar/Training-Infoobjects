// gatewayService.js

const {ServiceBroker} = require("moleculer");
const HTTPServer = require("moleculer-web");


// Create Brocker For Node 1 
// Define node id and set Communication bus 

const brockerGateway = new ServiceBroker({
    nodeID : "node-1",
    transporter : "NATS"
});

// create Gateway Service

brockerGateway.createService({
  //define Service
  nane: "gateway",
  //Load HTTP Server
  mixins: [HTTPServer],

  settings: {
    routes: [
      {
        aliases: {
          // when the "GET /products" request is made  the "listProducts" action
          // of "products" Service is excuted.
          "GET /products": "products.listProducts",
        },
      },
    ],
  },
});


brockerGateway
  .start()
  .catch((err) => console.log(`Error Occured!!!!! ${err.message}`));
        
