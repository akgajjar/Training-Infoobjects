"use strict";

const dataSvc = require("../common/dataService.js");
module.exports = {
  name: "microservice",

  /**
   * Service settings
   */
  settings: {},

  /**
   * Service metadata
   */
  metadata: {},

  /**
   * Service dependencies
   */
  //dependencies: [],

  /**
   * Actions
   */
  actions: {

    testData(ctx) {
      return new this.Promise((resolve, reject) => {
        dataSvc.testData(ctx, (err, res) => {
          if (err) {
            reject(err);
          } else {
            resolve(res);
          }
        });
      }).then(
        res => {
          return res;
        },
        err => {
          return err;
        }
      );
    }
  },

  /**
   * Events
   */
  events: {},

  /**
   * Methods
   */
  methods: {},

  /**
   * Service created lifecycle event handler
   */
  created() {},

  /**
   * Service started lifecycle event handler
   */
  started() {},

  /**
   * Service stopped lifecycle event handler
   */
  stopped() {}
};
