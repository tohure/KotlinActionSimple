package com.project.youraction

import com.google.actions.api.ActionRequest
import com.google.actions.api.ActionResponse
import com.google.actions.api.DialogflowApp
import com.google.actions.api.ForIntent
import org.slf4j.LoggerFactory

class YourActionApp : DialogflowApp() {

    @Suppress("PrivatePropertyName")
    private val LOGGER = LoggerFactory.getLogger(YourActionApp::class.java)

    @ForIntent("Default Welcome Intent")
    fun welcomeIntent(request: ActionRequest): ActionResponse {
        LOGGER.info("Starting intent")

        //Respond Action
        val responseBuilder = getResponseBuilder(request)
        responseBuilder.add("PREPARE HERE YOUR RESPONSE")
        responseBuilder.endConversation()
        return responseBuilder.build()
    }

}
