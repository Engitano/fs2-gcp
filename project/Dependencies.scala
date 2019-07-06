import sbt._

object Dependencies {

  def resolvers(): Seq[MavenRepository] = Seq(
    Resolver.sonatypeRepo("releases")
  )

  def apply(): Seq[ModuleID] = Seq(
    "co.fs2"               %% "fs2-core"                        % "1.1.0-M1",
    "org.typelevel"        %% "cats-effect"                     % "2.0.0-M4",
    "io.grpc"               % "grpc-core"             % scalapb.compiler.Version.grpcJavaVersion,
    "io.grpc"               % "grpc-stub"             % scalapb.compiler.Version.grpcJavaVersion,
    "org.lyranthe.fs2-grpc" %% "java-runtime"         % org.lyranthe.fs2_grpc.buildinfo.BuildInfo.version,
    "com.thesamet.scalapb"  %% "scalapb-runtime"      % scalapb.compiler.Version.scalapbVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc"            %
      scalapb.compiler.Version.scalapbVersion exclude("com.google.api.grpc","proto-google-common-protos"),
    "com.thesamet.scalapb"  %% "scalapb-runtime"      % scalapb.compiler.Version.scalapbVersion % "protobuf"
  )
}
