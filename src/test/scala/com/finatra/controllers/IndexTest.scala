package com.finatra.controllers

import com.finatra.FinatraServer
import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class IndexTest extends FeatureTest {
  override val server = new EmbeddedHttpServer(new FinatraServer)

  test("FinatraServer#perform GET /") {
    server.httpGet(
      path = "/",
      andExpect = Status.Ok,
      withJsonBody =
        """
        {
          "name" : "Deployment Test",
          "friends": ["Red", "Green"]
        }"""
    )
  }

  test("FinatraServer#perform POST /") {
    server.httpPost(
      path = "/",
      postBody =
        """
        {
          "id": "10",
          "name": "Samuel"
        }
        """,
      andExpect = Status.Ok,
      withBody = "Hello Samuel with id 10"
    )
  }
}
