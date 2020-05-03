package com.akka.http.load.test

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

abstract class BaseSimulation(baseUrl: String, scenarioName: String) extends Simulation {
  val totalConcurrentUsers = 5000
  val rampUpDuration: FiniteDuration = 10.seconds
  val pauseDuration = 5

  lazy val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseUrl)
  lazy val scn: ScenarioBuilder = scenario(scenarioName)
    .exec(http("Ping").get("/ping"))
    .exec(http("IsPrime").get("/prime/100899"))
    .pause(pauseDuration)


  setUp(scn
    .inject(rampUsers(totalConcurrentUsers) during rampUpDuration)
    .protocols(httpProtocol)
  )
}
