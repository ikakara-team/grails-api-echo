class ApiEchoGrailsPlugin {
  def version = "0.2"
  def grailsVersion = "2.2 > *"
  def title = "API Echo Plugin"
  def author = "Allen Arakaki"
  def authorEmail = ""
  def description = '''
Used to help debug 3rd party API requests, by echoing the contents of the request back to the user to insure that
requests are properly formed.
'''
  def documentation = "http://grails.org/plugin/api-echo"
  def license = "APACHE"
  def issueManagement = [url: 'https://github.com/ikakara-team/grails-api-echo/issues']
  def scm = [url: 'https://github.com/ikakara-team/grails-api-echo']
}
