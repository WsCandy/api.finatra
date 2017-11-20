package com.finatra.modules.jtw

import io.igl.jwt._
import play.api.libs.json.{JsNumber, JsValue}

case class Uid(value: Long) extends ClaimValue {
  override val field: ClaimField = Uid
  override val jsValue: JsValue = JsNumber(value)
}

object Uid extends (Long => Uid) with ClaimField {
  override def attemptApply(value: JsValue): Option[ClaimValue] =
    value.asOpt[Long].map(apply)

  override val name: String = "uid"
}

class JWT() {
  val secret = "secrets"

  def getToken(payload: Seq[ClaimValue]): String = {
    val jwt = new DecodedJwt(Seq(Alg(Algorithm.HS256), Typ("JWT")), payload)
    return jwt.encodedAndSigned(this.secret)
  }
}
