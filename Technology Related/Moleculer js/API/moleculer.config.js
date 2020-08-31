"use strict";

module.exports = {
  namespace: "",
  nodeID: null,

  logger: true,
  logLevel: "info",
  logFormatter: "default",

  // Transporter is an important module if you are running services on multiple nodes. Transporter communicates with other nodes. It transfers events, calls requests and processes responses …etc. If a service runs on multiple instances on different nodes, the requests will be load-balanced among live nodes.
  transporter: {
    type: "NATS",
    options: {
      url: "nats://localhost:4222"
    }
  },

  //cacher: "Redis",

  // It serializes the packets to JSON string and deserializes the received data to packet.
  serializer: "JSON",

  requestTimeout: 10 * 1000,
  requestRetry: 0,
  maxCallLevel: 100,
  heartbeatInterval: 5,
  heartbeatTimeout: 15,

  disableBalancer: false,

  registry: {
    strategy: "RoundRobin",
    preferLocal: true
  },

  circuitBreaker: {
    enabled: false,
    maxFailures: 3,
    halfOpenTime: 10 * 1000,
    failureOnTimeout: true,
    failureOnReject: true
  },

  validation: true,
  validator: null,
  metrics: false,
  metricsRate: 1,
  statistics: false,
  internalActions: true,

  hotReload: true,

  replCommands: null,

  // Register middlewares
  middlewares: [],

  // Called after broker created.
  created(broker) {},

  // Called after broker started.
  started(broker) {},

  // Called after broker stopped.
  stopped(broker) {}
};
