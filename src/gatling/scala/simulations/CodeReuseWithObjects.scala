package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class CodeReuseWithObjects extends BaseSimulation {

  val scn = scenario("Video Game DB")
    .exec(getAllVideoGames())
      .pause(5)
      .exec(getSpecificVideoGame())
      .pause(5)
      .exec(getAllVideoGames())


  def getAllVideoGames() = {
    exec(http("Get All Video Games")
      .get("videogames")
      .check(status.is(200)))
  }

  def getSpecificVideoGame() = {
    exec(http("Get specific game")
      .get("videogames/1")
      .check(status.in(200 to 201)))
  }

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
