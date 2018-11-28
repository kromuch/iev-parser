package object models {

  case class AirlineLang(id: Int,
                         name: String,
                         icao: String,
                         about: String,
                         logoName: String,
                         locale: String,
                         showOnSite: Boolean,
                         createdAt: Long,
                         updatedAt: Long)

  case class Airline(en: Option[AirlineLang], ru: Option[AirlineLang], ua: Option[AirlineLang])

  case class DepartureFlight(
                              ID: Long,
                              fltNo: String,
                              `fltTypeID.code`: String,
                              `fltTypeID.name`: String,
                              `fltCatID.code`: String,
                              `fltCatID.name`: String,
                              `planeTypeID.code`: String,
                              `planeTypeID.IATA`: String,
                              `planeTypeID.name`: String,
                              planeNo: Option[String],
                              `airportToID.code`: String,
                              `airportToID.IATA`: String,
                              `airportToID.name`: String,
                              checkinNo: Option[String],
                              gateNo: Option[String],
                              term: String,
                              `standID.code`: String,
                              `carrierID.code`: String,
                              timeDepShedule: String,
                              timeBoard: Option[String],
                              timeDepExpectCalc: String,
                              timeDepFact: Option[String],
                              timeTakeofFact: Option[String],
                              timeToStand: String,
                              timeLandFact: Option[String],
                              `delayReasonID.code`: String,
                              `delayReasonID.name`: String,
                              psgCount: Option[Int],
                              cargoCount: Option[Int],
                              mailCount: Option[Int],
                              bagCount: Option[Int],
                              bagWeigth: Option[Int],
                              `handlerID.code`: String,
                              `handlerID.name`: String,
                              actual: String,
                              status: String,
                              `airportToID.name_en`: String,
                              `airportToID.city`: String,
                              `airportToID.city_en`: String,
                              `airportToID.city_ru`: String,
                              showOnSite: Int,
                              logo: String,
                              airline: Airline
                            ) {
    def getOptions: List[Option[Any]] = List(
      planeNo: Option[String],
      checkinNo: Option[String],
      gateNo: Option[String],
      timeBoard: Option[String],
      timeDepFact: Option[String],
      timeTakeofFact: Option[String],
      timeLandFact: Option[String],
      psgCount: Option[Int],
      cargoCount: Option[Int],
      mailCount: Option[Int],
      bagCount: Option[Int],
      bagWeigth: Option[Int]
    )
  }

  case class ArrivalFlight(
                            fltNo: String,
                            `fltTypeID.code`: String,
                            `fltTypeID.name`: String,
                            `fltCatID.code`: String,
                            `fltCatID.name`: String,
                            `planeTypeID.code`: String,
                            `planeTypeID.IATA`: String,
                            `planeTypeID.name`: String,
                            planeNo: Option[String],
                            `airportFromID.code`: String,
                            `airportFromID.IATA`: String,
                            `airportFromID.name`: String,
                            term: String,
                            `standID.code`: String,
                            `carrierID.code`: String,
                            timeArrShedule: String,
                            timeArrExpectCalc: String,
                            timeTakeofFact: Option[String],
                            timeToStand: String,
                            timeLandCalc: String,
                            timeStandCalc: String,
                            timeLandFact: Option[String],
                            timeStandFact: Option[String],
                            psgCount: Option[Int],
                            cargoCount: Option[Int],
                            mailCount: Option[Int],
                            bagCount: Option[Int],
                            bagWeigth: Option[Int],
                            note: Option[String],
                            actual: String,
                            status: String,
                            `airportFromID.name_en`: String,
                            `airportFromID.city`: String,
                            `airportFromID.city_en`: String,
                            `airportFromID.city_ru`: String,
                            ID: Long,
                            showOnSite: Byte,
                            logo: Option[String],
                            airline: Airline
                          ) {
    def getOptions: List[Option[Any]] = List(
      planeNo: Option[String],
      timeTakeofFact: Option[String],
      timeLandFact: Option[String],
      timeStandFact: Option[String],
      psgCount: Option[Int],
      cargoCount: Option[Int],
      mailCount: Option[Int],
      bagCount: Option[Int],
      bagWeigth: Option[Int],
      note: Option[String],
      logo: Option[String]
    )
  }

  type Departure = List[DepartureFlight]

  type Arrival = List[ArrivalFlight]

  case class Body(departure: Departure, arrival: Arrival)

  case class Error(code: String)

  case class Daily(body: Body, error: Error)

}
