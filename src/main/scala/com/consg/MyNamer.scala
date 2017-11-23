package com.consg

import java.nio.file.{Path => NioPath}

import com.twitter.finagle._
import com.twitter.util._
import io.buoyant.namer.EnumeratingNamer

class MyNamer(rootDir: NioPath, prefix: Path) extends EnumeratingNamer {

  def lookup(path: Path): Activity[NameTree[Name]] = {
    println("lookup path: " + path)

    val address1 = Address("127.0.0.1", 7777)
    val addr = Addr.Bound(Set(address1), Addr.Metadata.empty)
    val varr = Var.apply(addr)

    Activity.value(NameTree.Leaf(Name.Bound(varr, path, path)))
  }

  override def getAllNames: Activity[Set[Path]] = {
    println("getAllNames!")
    Activity.value(Set.apply(Path.read("animal")))
  }

}
