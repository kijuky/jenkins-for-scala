lazy val root = project
  .in(file("."))
  .settings(
    name := "jenkins-for-scala",
    scalaVersion := "2.12.20",
    crossScalaVersions := Seq(scalaVersion.value, "3.3.4"),
    resolvers += "JCenter" at "https://jcenter.bintray.com/",
    libraryDependencies ++= Seq(
      "io.github.cdancy" % "jenkins-rest" % "1.0.2"
    )
  )

inThisBuild(
  Seq(
    organization := "io.github.kijuky",
    homepage := Some(url("https://github.com/kijuky/jenkins-for-scala")),
    licenses := Seq(
      "Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0")
    ),
    developers := List(
      Developer(
        "kijuky",
        "Kizuki YASUE",
        "ikuzik@gmail.com",
        url("https://github.com/kijuky")
      )
    ),
    versionScheme := Some("early-semver"),
    sonatypeCredentialHost := "s01.oss.sonatype.org",
    sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
  )
)
