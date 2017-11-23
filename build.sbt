name := "plug"
version := "1"
scalaVersion := "2.12.1"

libraryDependencies += "io.buoyant" % "linkerd-core_2.12" % "1.3.2" % "provided"
libraryDependencies += "io.buoyant" % "namer-fs_2.12" % "1.3.2" % "provided"

//def twitterUtil(mod: String) =
//  "com.twitter" %% s"util-$mod" %  "6.45.0"
//
//def finagle(mod: String) =
//  "com.twitter" %% s"finagle-$mod" % "6.45.0"
//
//def linkerd(mod: String) =
//  "io.buoyant" %% s"linkerd-$mod" % "1.3.1"
//
//val jacksonVersion = "2.8.4"
//
//libraryDependencies ++=
//  finagle("http") % "provided" ::
//    twitterUtil("core") % "provided" ::
//    linkerd("core") % "provided" ::
//    linkerd("protocol-http") % "provided" ::
//    "io.buoyant" %% "finagle-buoyant" % "1.3.1" % "provided" ::
//    "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion % "provided" ::
//    "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion % "provided" ::
//    "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion % "provided" ::
//    "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion % "provided" ::
//    "io.buoyant" %% "linkerd-core_2.11" % "1.3.2" % "provided" ::
//    Nil
