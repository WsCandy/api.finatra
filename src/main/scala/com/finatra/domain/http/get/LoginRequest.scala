package com.finatra.domain.http.get

import com.twitter.finatra.request.QueryParam

case class LoginRequest(@QueryParam id: Long)
