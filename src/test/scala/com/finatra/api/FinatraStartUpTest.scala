package com.finatra.api

import com.finatra.FinatraServer
import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class FinatraStartUpTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(
    twitterServer = new FinatraServer,
    stage = Stage.PRODUCTION,
    verbose = false
  )

  test("Server#startup") {
    server.assertHealthy()
  }
}
