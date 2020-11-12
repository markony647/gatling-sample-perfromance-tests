import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import simulations.{AddPauseTime, BasicLoadSimulation, CheckResponseBodyAndExtract, CheckResponseCode, CodeReuseWithObjects, CsvFeeder, CsvFeederToCustom, CustomFeeder, FixedDurationLoadSimulation, RampUsersLoadSimulation}

object MyGatlingRunner {

  def main(args: Array[String]): Unit = {

    val simClass = classOf[FixedDurationLoadSimulation].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }

}
