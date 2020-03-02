apply(plugin = "maven-publish")

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri(if (System.getenv("REPOSITORY_URL_RELEASE") == null) "$buildDir/repos/releases" else System.getenv("REPOSITORY_URL_RELEASE"))
            val snapshotsRepoUrl = uri(if (System.getenv("REPOSITORY_URL_SNAPSHOT") == null) "$buildDir/repos/snapshots" else System.getenv("REPOSITORY_URL_SNAPSHOT"))
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }
}
