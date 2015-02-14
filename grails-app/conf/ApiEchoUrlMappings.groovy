class ApiEchoUrlMappings {

  static mappings = {
    // handles all paths
    "/echo/$path**"(controller:"echo", parseRequest: false) {
    }
    // handles no path
    "/echo/"(controller:"echo", parseRequest: false) {
    }
  }
}
