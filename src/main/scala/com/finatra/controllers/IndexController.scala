package com.finatra.controllers

import com.finatra.domain.http.{IndexGetResponse, IndexPostRequest}
import com.google.inject.{Inject, Singleton}
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

@Singleton
class IndexController @Inject()
  extends Controller {

  get("/") { request: Request =>
    IndexGetResponse.apply("Blue/Green Deployment Test", Array("Blue", "Green"))
  }

  post("/") { indexRequest: IndexPostRequest =>
    "Hello " + indexRequest.name + " with id " + indexRequest.id
  }
}
