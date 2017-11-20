package com.finatra.controllers

import com.finatra.domain.http.get.{LoginGetResponse, LoginRequest}
import com.finatra.modules.jtw.{JWT, Uid}
import com.google.inject.{Inject, Singleton}
import com.twitter.finatra.http.Controller

@Singleton
class LoginController @Inject()(jtw: JWT)
  extends Controller {

  get("/login") { request: LoginRequest =>
    val id = request.id
    LoginGetResponse.apply(token = jtw.getToken(Seq(Uid(id))))
  }
}
