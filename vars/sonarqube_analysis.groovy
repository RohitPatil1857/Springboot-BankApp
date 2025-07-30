def call(String SonarQubeAPI, String Projectname, String ProjectKey) {
  withSonarQubeEnv("${SonarQubeAPI}") {
    sh """
      mvn clean install -DskipTests
      ${SONAR_HOME}/bin/sonar-scanner \
        -Dsonar.projectName=${Projectname} \
        -Dsonar.projectKey=${ProjectKey} \
        -Dsonar.java.binaries=target \
        -X
    """
  }
}
