import models._
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.io.{Source => SCSource}

object Main extends App with WebServer {
  implicit val formats: DefaultFormats.type = DefaultFormats
//  val string = SCSource.fromFile("17-07-2018.json").getLines().mkString
  val string = SCSource.fromFile("12-10-2018.json").getLines().mkString
  val daily = parse(string).extract[Daily]

  println(s"Departures ${daily.body.departure.groupBy(_.ID).size}")
  println(s"Arrivals ${daily.body.arrival.groupBy(_.ID).size}")
  println(s"Departures full info ${daily.body.departure.map(_.getOptions).count(x => !x.exists(_.isEmpty))}")
  println(s"Arrivals full info ${daily.body.arrival.map(_.getOptions).count(x => !x.exists(_.isEmpty))}")

  println(daily.body.departure.find(_.`planeTypeID.IATA` == "7M8"))
}
