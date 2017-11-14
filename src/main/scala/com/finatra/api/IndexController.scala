package com.finatra.api

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.google.inject.Inject
import com.google.inject.Singleton

@Singleton
class IndexController @Inject()
  extends Controller {

  get("/") { request: Request =>
    ApiResponse.apply("Samuel", Array("Giles", "Samuel"))
  }

  post("/") { indexRequest: IndexRequest =>
    "Hello " + indexRequest.name + " with id " + indexRequest.id
  }
}
