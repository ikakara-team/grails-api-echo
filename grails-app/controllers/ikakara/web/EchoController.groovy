/*
 * Copyright 2014 Allen Arakaki. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ikakara.web

import org.apache.commons.io.IOUtils

class EchoController {
  private static final Set PARAMS_FILTER = ['action', 'controller', 'path']

  def index() {
    log.debug "echo ${request.contextPath} servlet: ${request.servletPath} path: ${request.pathInfo} params: ${params}"

    def map = new TreeMap()
    request.headerNames.each { String name -> map[name] = request.getHeader(name) }

    // parseRequest: false is broken - we'll have to get the POST data in params
    try {
      // this is broken
      def body = request.reader.text // read the content body
      log.info "parseRequest: false - WORKING WORKING WORKING WORKING WORKING!"
    } catch(e) {
      // this will be
      log.error "parseRequest: false - $e.message"
    }

    // this doesn't behave the same as request.getReader().text
    def enc = request.characterEncoding ?: "UTF-8"
    def body = IOUtils.toString(request.inputStream, enc)
    if (!body) {
      Set setQuery = []
      request.queryString?.split('&')?.each {
        def param = it.split('=')
        if(param?.length > 0) {
          setQuery.add(param[0])
        }
      }

      body = [:]
      params.each { key, value ->
        if(PARAMS_FILTER.contains(key)) {
          // ignore
        } else if(setQuery.contains(key)) {
          // ignore the queryString params
        } else {
          body[key] = value
        }
      }
    }

    render(contentType: "application/json", encoding: enc) {
      [
        remote: [
          addr: request.remoteAddr,
          port: request.remotePort,
        ],
        server: [
          port: request.serverPort,
        ],
        protocol: request.protocol,
        scheme: request.scheme,
        method: request.method,
        authType: request.authType,
        characterEncoding: request.characterEncoding,
        //pathInfo: request.pathInfo, // seems to always be null
        //requestURI: request.requestURI,
        //requestURL: request.requestURL,
        //remoteUser: request.remoteUser,
        //contextPath: request.contextPath,
        path: params.path,
        queryString: request.queryString,
        header: map,
        content: body
      ]
    }
  }
}
