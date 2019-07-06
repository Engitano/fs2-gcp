import sbt._
import sbt.Keys._
import sbt.URL
import bintray.BintrayKeys._
import sbtprotoc.ProtocPlugin.autoImport._
import org.lyranthe.fs2_grpc.java_runtime.sbt_gen.Fs2GrpcPlugin.autoImport._
import sbtrelease.ReleasePlugin.autoImport._
object Common {

  val scala213 = "2.13.0"
  val scala212 = "2.12.8"
  val scala211 = "2.11.12"
  val supportedScalaVersions = List(scala213, scala212, scala211)

  def apply() = Seq(
    scalaVersion := scala213,
    organization := "com.engitano",
    organizationName := "Engitano",
    startYear := Some(2019),
    licenses += ("MIT", new URL("http://opensource.org/licenses/MIT")),
    crossScalaVersions := supportedScalaVersions,
    resolvers ++= Dependencies.resolvers(),
    libraryDependencies := Dependencies(),
    bintrayOrganization := Some("engitano"),
    bintrayPackageLabels ++= Seq("gcp", "grpc", "fs2"),
    releaseCommitMessage := s"Setting version to ${(version in ThisBuild).value} [ci skip]",
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
