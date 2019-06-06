import sbt._
import sbt.Keys._
import sbt.URL
import bintray.BintrayKeys._
import sbtprotoc.ProtocPlugin.autoImport._
import org.lyranthe.fs2_grpc.java_runtime.sbt_gen.Fs2GrpcPlugin.autoImport._

object Common {
  def apply() = Seq(
    scalaVersion := "2.12.8",
    organization := "com.engitano",
    organizationName := "Engitano",
    startYear := Some(2019),
    licenses += ("MIT", new URL("http://opensource.org/licenses/MIT")),
    resolvers ++= Dependencies.resolvers(),
    libraryDependencies := Dependencies(),
    bintrayOrganization := Some("engitano"),
    bintrayPackageLabels ++= Seq("gcp", "grpc", "fs2"),
    Compile / PB.targets := Seq(
        scalapb.gen(flatPackage = true) -> (Compile / sourceManaged).value
    ),
    Compile / PB.includePaths := Seq(
      target.value / "protobuf_external",
      (ThisBuild / baseDirectory).value / "googleapis",
    ),
    scalapbCodeGeneratorOptions += CodeGeneratorOption.FlatPackage,
    Compile / PB.targets := scalapbCodeGenerators.value

  )
}
