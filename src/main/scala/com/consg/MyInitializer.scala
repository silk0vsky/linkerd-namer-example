package com.consg

import io.buoyant.namer.NamerInitializer

class MyInitializer extends NamerInitializer {

  println("MyInitializer!")

  val configClass = classOf[MyConfig]

  override def configId = "com.consg.MyInitializer"

}

object MyInitializer extends MyInitializer
