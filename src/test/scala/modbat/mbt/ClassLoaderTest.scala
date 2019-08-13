package modbat.mbt

import java.io.File

import org.scalatest.FlatSpec

class ClassLoaderTest extends FlatSpec {
  "Class Loader URLs" should "exist" in {
    MBT.configClassLoader("./")

    for (u <-  MBT.classLoaderURLs) {
      val basename = u.getFile()
      val file = new File(basename)
      assert(file.exists())
    }
  }
}
