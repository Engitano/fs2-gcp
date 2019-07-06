import sbt.configs

publishTo := Some(Resolver.bintrayRepo("engitano", "maven"))

lazy val root = (project in file("."))
  .settings(
    skip in publish := true
  )
  .settings(Common())
  .aggregate(
    `fs2-google-common-protos`,
    `fs2-google-iam-v1`,
    `fs2-google-cloud-pubsub-v1`,
    `fs2-google-cloud-datastore-v1`,
    `fs2-google-cloud-datastore-admin-v1`,
    `fs2-google-cloud-firestore-v1`,
    `fs2-google-cloud-firestore-admin-v1`,
    `fs2-google-cloud-tasks-v1`,
    `fs2-google-cloud-bigtable-v2`,
    `fs2-google-cloud-bigtable-admin-v2`,
    `fs2-google-cloud-spanner-v1`,
    `fs2-google-cloud-spanner-admin-database-v1`,
    `fs2-google-cloud-spanner-admin-instance-v1`
    ).enablePlugins(Fs2Grpc)

lazy val `fs2-google-common-protos` = (project in file("lib") / "common")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("google-common-protos"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "api",
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "cloud" / "audit",
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "logging" / "type",
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "longrunning",
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "rpc",
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "type"
    ),
  )
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-iam-v1` = (project in file("lib") / "iam")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("iam"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "iam" / "v1"
    ),
  )
  .dependsOn(`fs2-google-common-protos`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-pubsub-v1` = (project in file("lib") / "pubsub")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("pubsub"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "pubsub" / "v1"
    ),
  )
  .dependsOn(`fs2-google-common-protos`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-datastore-v1` = (project in file("lib") / "datastore")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("datastore"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "datastore" / "v1",
    ),
  )
  .dependsOn(`fs2-google-common-protos`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-datastore-admin-v1` = (project in file("lib") / "datastore-admin")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("datastore"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "datastore" / "admin" / "v1"
    ),
  )
  .dependsOn(`fs2-google-common-protos`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-firestore-v1` = (project in file("lib") / "firestore")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("firestore"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "firestore" / "v1"
    ),
  )
  .dependsOn(`fs2-google-common-protos`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-firestore-admin-v1` = (project in file("lib") / "firestore-admin")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("firestore"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "firestore" / "admin" / "v1"
    ),
  )
  .dependsOn(`fs2-google-common-protos`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-tasks-v1` = (project in file("lib") / "cloudtasks")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("cloudtasks"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "cloud" / "tasks" / "v2"
    ),
  )
  .dependsOn(`fs2-google-common-protos`, `fs2-google-iam-v1`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-bigtable-v2` = (project in file("lib") / "bigtable")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("bigtable"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "bigtable" / "v2",
    ),
  )
  .dependsOn(`fs2-google-common-protos`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-bigtable-admin-v2` = (project in file("lib") / "bigtable-admin")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("bigtable"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "bigtable" / "admin" / "v2"
    ),
  )
  .dependsOn(`fs2-google-common-protos`, `fs2-google-iam-v1`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-spanner-v1` = (project in file("lib") / "spanner")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("spanner"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "spanner" / "v1"
    ),
  )
  .dependsOn(`fs2-google-common-protos`, `fs2-google-iam-v1`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-spanner-admin-database-v1` = (project in file("lib") / "spanner-admin")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("spanner"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "spanner" / "admin" / "database" / "v1"
    ),
  )
  .dependsOn(`fs2-google-common-protos`, `fs2-google-iam-v1`)
  .enablePlugins(Fs2Grpc)

lazy val `fs2-google-cloud-spanner-admin-instance-v1` = (project in file("lib") / "spanner-instance")
  .settings(
    Common(),
    bintrayPackageLabels ++= Seq("spanner"),
    Compile / PB.protoSources := Seq(
      (ThisBuild / baseDirectory).value /  "googleapis" / "google" / "spanner" / "admin" / "instance" / "v1"
    ),
  )
  .dependsOn(`fs2-google-common-protos`, `fs2-google-iam-v1`)
  .enablePlugins(Fs2Grpc)