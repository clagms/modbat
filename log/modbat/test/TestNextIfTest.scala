package modbat.test

import modbat.dsl.After;
import modbat.dsl.Before;
import modbat.dsl.Init;
import modbat.dsl.Shutdown;
import modbat.mbt.MBT
import modbat.log.Log
import modbat.offline.ReplayRandom

object TestNextIfTest {
  def test3ba471c1785a0175() {
    MBT.clearLaunchedModels()
    MBT.setRNG (new ReplayRandom(0x3ba471c1785a0175L, Array(), 0))
    val m0: MBT = MBT.launch(null)

    m0.setExpectedOverrideTrans(0)
    m0.executeTransition(m0.getTransition(0))
    // modbat/test/NextIfTest.scala:7: ok --> err

    m0.setExpectedException("java.lang.AssertionError")
    m0.executeTransition(m0.getTransition(1))
    // modbat/test/NextIfTest.scala:9: assert
    MBT.setTestFailed(true)
    MBT.cleanup()

  }

  def main(args: Array[String]) {
    Log.setLevel(3)
    MBT.setMaybeProbability(0.5)
    if (args.contains("--rethrow-exceptions")) {
      MBT.setRethrowExceptions(true)
    }
    MBT.configClassLoader("build/modbat-test.jar")
    MBT.loadModelClass ("modbat.test.NextIfTest")
    MBT.invokeAnnotatedStaticMethods(classOf[Init], null)

    test3ba471c1785a0175()

    MBT.invokeAnnotatedStaticMethods(classOf[Shutdown], null)
  }
}
