name := "gatling-test"

version := "0.1"

enablePlugins(GatlingPlugin)

scalaVersion := "2.12.10"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1" % "test,it",
  "io.gatling"            % "gatling-test-framework"    % "3.3.1" % "test,it"
)
