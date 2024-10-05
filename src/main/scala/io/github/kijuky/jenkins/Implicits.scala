package io.github.kijuky.jenkins

import com.cdancy.jenkins.rest.domain.common.IntegerResponse
import com.cdancy.jenkins.rest.features.JobsApi
import com.cdancy.jenkins.rest.{JenkinsAuthentication, JenkinsClient}

import scala.collection.JavaConverters._

object Implicits {
  def createJenkinsClient(
    endpoint: String,
    accessToken: String
  ): JenkinsClient =
    new JenkinsClient(
      endpoint,
      new JenkinsAuthentication.Builder().apiToken(accessToken).build(),
      null,
      null
    )

  implicit class RichJobsApi(jobsApi: JobsApi) {
    def buildWithParameters(
      folderPath: String,
      jobName: String,
      params: (String, String)*
    ): IntegerResponse =
      jobsApi.buildWithParameters(
        folderPath,
        jobName,
        params.toMap.mapValues(Seq(_).asJava).toMap.asJava
      )
  }
}
