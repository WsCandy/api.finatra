package com.finatra.api

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters}
import com.twitter.finatra.http.routing.HttpRouter

object FinatraServerMain extends FinatraServer

class FinatraServer extends HttpServer  {
  override val disableAdminHttpServer: Boolean = false

  override def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .add[IndexController]
  }
}