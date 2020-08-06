"use strict";

const routes = require("../routes");
const _ = require("lodash");
const ApiGateway = require("moleculer-web");

const Eureka = require("eureka-js-client").Eureka;
const eurekaConfig = require("../config.js").eureka;
const env = require("../config.js").env;

const client = new Eureka({
  // application instance information
  instance: {
    app: "microserviceApi",
    hostName: env.hostName,
    ipAddr: env.ipAddr,
    port: {
      $: env.port,
      "@enabled": "true"
    },
    vipAddress: "microserviceApi",
    statusPageUrl: "http://localhost:4471",
    dataCenterInfo: {
      "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
      name: "MyOwn"
    }
  },
  eureka: {
    // eureka server host / port
    host: eurekaConfig.host,
    port: eurekaConfig.port,
    servicePath: eurekaConfig.servicePath
  }
});

module.exports = {
  name: "api",
  mixins: [ApiGateway],

  // More info about settings: http://moleculer.services/docs/moleculer-web.html
  settings: {
    port: process.env.PORT || 4471,

    routes: routes,

    // Serve assets from "public" folder
    assets: {
      folder: "public"
    },

    // logRequestParams: "info",
    // logResponseData: "info",

    onError(req, res, err) {
      // Return with the error as JSON object
      console.log("Global err", err);
      res.setHeader("Content-type", "application/json; charset=utf-8");
      res.writeHead(err.code || 500);

      if (err.code == 422) {
        let o = {};
        err.data.forEach(e => {
          let field = e.field.split(".").pop();
          o[field] = e.message;
        });

        res.end(
          JSON.stringify(
            {
              errors: o
            },
            null,
            2
          )
        );
      } else {
        const errObj = _.pick(err, ["name", "message", "code", "type", "data"]);
        res.end(JSON.stringify(errObj, null, 2));
      }
      this.logResponse(req, res, err ? err.ctx : null);
    }
  },
  methods: {},

  /**
   * Service created lifecycle event handler
   */
  created() {},

  /**
   * Service started lifecycle event handler
   */
  started() {
    client.start();
  },

  /**
   * Service stopped lifecycle event handler
   */
  stopped() {
    client.stop();
  }
};
