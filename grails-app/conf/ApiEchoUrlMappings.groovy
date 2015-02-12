class ApiEchoUrlMappings {

  static mappings = {
    // handles all paths
    "/echo/$path**"(controller:"echo", action:"index", parseRequest: false) {
      constraints {
        // apply constraints here
      }
    }
    // handles no path
    "/echo/"(controller:"echo", action:"index", parseRequest: false) {
      constraints {
        // apply constraints here
      }
    }
  }
}
