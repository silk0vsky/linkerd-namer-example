package com.consg

import java.nio.file.{Path => NioPath}

import com.twitter.finagle._
import com.twitter.util._
import io.buoyant.namer.EnumeratingNamer

class MyNamer(rootDir: NioPath, prefix: Path) extends EnumeratingNamer {

  private object PortNum {
    val Max = math.pow(2, 16) - 1
    def unapply(s: String): Option[Int] =
      Try(s.toInt).toOption.filter { p => (0 < p && p <= Max) }
  }

  case class MalformedAddress(text: String)
    extends IllegalArgumentException(s"malformed address: $text")

  def txtToAddress(txt: String): Try[Address] = {
    val Whitespace = """\s+""".r
    Whitespace.split(txt) match {
      case Array(host, PortNum(port)) => Try(Address(host, port))
      case _ => Throw(MalformedAddress(txt))
    }
  }

  private def txtToAddr(txt: String): Addr = {
    val lines = txt.split('\n').map(ln => ln.trim).filter(_.nonEmpty)

    Try.collect(lines.map(txtToAddress)) match {
      case Return(addrs) => Addr.Bound(addrs.toSet, Addr.Metadata.empty)
      case Throw(e) => Addr.Failed(e)
    }
  }

  def lookup(path: Path): Activity[NameTree[Name]] = {
    val addr = txtToAddr("""127.0.0.1 7778""")
    val varr = Var.apply(addr)

    println("lookup path: " + path)
    Activity.value(NameTree.Leaf(Name.Bound(varr, path, path)))

//    root.children.flatMap(lookup(prefix, path, _))
  }

  //  -------------------------------------------------
  override def getAllNames: Activity[Set[Path]] = {
    println("getAllNames!")
    Activity.value(Set.apply(Path.read("animal")))
  }

}
