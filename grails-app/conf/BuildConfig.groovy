grails.project.work.dir = 'target'

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {

  inherits 'global'
  log 'warn'

  repositories {
    mavenLocal()
    grailsCentral()
    mavenCentral()
  }

  plugins {
    // needed for testing
    build(":tomcat:8.0.15") { // 8.0.18 broken - https://jira.grails.org/browse/GPTOMCAT-29
      export = false
    }

    build(":release:3.0.1", ":rest-client-builder:2.0.3") {
      export = false
    }
  }
}
