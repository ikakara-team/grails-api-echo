grails.project.work.dir = 'target'
grails.project.target.level = 1.7
grails.project.source.level = 1.7

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
    build(":tomcat:8.0.20") { // 8.0.18 broken - https://jira.grails.org/browse/GPTOMCAT-29
      export = false
    }

    build(":release:3.1.0", ":rest-client-builder:2.1.0") {
      export = false
    }
  }
}
