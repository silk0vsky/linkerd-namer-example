package com.consg

import com.fasterxml.jackson.annotation.JsonIgnore
import com.twitter.finagle.{Path, Stack}
import io.buoyant.config.types.Directory
import io.buoyant.namer.NamerConfig

case class MyConfig(rootDir: Directory) extends NamerConfig {

  @JsonIgnore
  override def defaultPrefix: Path = Path.read("/io.my.fs")

  @JsonIgnore
  def newNamer(params: Stack.Params) = {
    println("params: " + params)
    new MyNamer(rootDir.path, prefix)
  }

}
