
package com.example

import kara.config.*
import kara.controllers.ParamTypeDeserializer

/**
 * This is the primary class for your application.
 */
public class Application(config: AppConfig) : kara.app.Application(config) {

    /**
     * Application-specific initialization code goes here.
     */
    {
         config.paramDeserializer.register(BOOLEAN)
    }

}

object BOOLEAN : ParamTypeDeserializer() {
    override fun deserialize(param: String): Any {
        return when (param.toLowerCase()) {
            "true" -> true
            "false" -> false
            else -> throw IllegalArgumentException("Not a boolean: $param")
        }
    }

    override fun isThisType(testType: Class<Any>): Boolean {
        return testType.toString() == "boolean" || testType.getName() == "java.lang.Boolean"
    }

}

