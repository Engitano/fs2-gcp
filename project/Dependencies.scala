import sbt._

object Dependencies {

  def resolvers(): Seq[MavenRepository] = Seq(
    Resolver.sonatypeRepo("releases")
  )

  def apply(): Seq[ModuleID] = Seq(
    "co.fs2"               %% "fs2-core"                        % "1.0.2",
    "org.typelevel"        %% "cats-effect"                     % "1.1.0",
    "com.thesamet.scalapb" %% "scalapb-runtime"                 % scalapb.compiler.Version.scalapbVersion % "protobuf"
  )
}
