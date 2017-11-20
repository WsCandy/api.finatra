package com.finatra.controllers

import com.finatra.FinatraServer
import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class LoginTest extends FeatureTest {
  override val server = new EmbeddedHttpServer(new FinatraServer)

  test("FinatraServer#perform GET /login") {
    server.httpGet(
      path = "/login?id=12345",
      andExpect = Status.Ok,
      withJsonBody =
        """
        {
          "token" : "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjEyMzQ1fQ._KD6-XCmaurP3rEaWYhj02zDBGUfZLU2zvTgWM1dKpg"
        }"""
    )

    server.httpGet(
      path = "/login",
      andExpect = Status.BadRequest,
      withJsonBody =
        """
           {
              "errors": [
                "id: queryParam is required"
              ]
           }
        """
    )
  }
}
