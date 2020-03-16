package com.project.youraction

import java.io.IOException
import java.util.HashMap
import java.util.concurrent.ExecutionException
import java.util.stream.Collectors
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "YourActionServlet", urlPatterns = ["/"], loadOnStartup = 1)
class YourActionServlet : HttpServlet() {

    private val yourActionApp = YourActionApp()

    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {

        val body = req.reader.lines().collect(Collectors.joining())

        try {
            //Here manage your request intent through your DialogflowApp
            val jsonResponse = yourActionApp.handleRequest(body, getHeadersMap(req)).get()
            resp.contentType = "application/json"
            resp.writer.write(jsonResponse)
        } catch (e: InterruptedException) {
            //Handling Error
        } catch (e: ExecutionException) {
            //Handling Error
        }
    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.status = 401
        resp.contentType = "text/plain"
        resp.writer.println("Unauthorised")
    }

    private fun getHeadersMap(request: HttpServletRequest): Map<String, String> {

        val map = HashMap<String, String>()

        val headerNames = request.headerNames
        while (headerNames.hasMoreElements()) {
            val key = headerNames.nextElement() as String
            val value = request.getHeader(key)
            map[key] = value
        }
        return map
    }

}