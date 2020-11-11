import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import simulations.{AddPauseTime, CheckResponseBodyAndExtract, CheckResponseCode, CodeReuseWithObjects, CsvFeeder, CsvFeederToCustom}

object MyGatlingRunner {

  def main(args: Array[String]): Unit = {

    val simClass = classOf[CsvFeederToCustom].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }

}
