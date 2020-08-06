module.exports = [
    {
      path: "/api/microservice",
      aliases: {
        "GET /test": "microservice.testData"
      },
      // Disable to call not-mapped actions
      mappingPolicy: "restrict",
      // Set CORS headers
      cors: true,
      // Parse body content
      bodyParser: {
        json: {
          strict: false
        },
        urlencoded: {
          extended: false
        }
      }
    }
  ];
  