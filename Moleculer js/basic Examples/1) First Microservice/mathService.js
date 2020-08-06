const {ServiceBroker} = require("moleculer");



//crate brocker

const broker = new ServiceBroker();


// Define a Service

broker.createService({
    name : "math",
    actions : {
        add(ctx){
            return Number(ctx.params.a) + Number(ctx.params.b);

        }
    }
});




// start a broker 

broker.start()
        .then(()=> broker.call("math.add",{a:5, b:3}))
        //print response
        .then(res => console.log("5 + 3 = "+ res))
        .catch(err => console.log(`Error Occured!!!!! ${err.message}`));
        