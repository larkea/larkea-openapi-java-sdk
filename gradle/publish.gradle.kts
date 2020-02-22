apply(plugin = "maven-publish")

configure<PublishingExtension> {

    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri(System.getProperty("REPOSITORY_URL_RELEASE", "$buildDir/repos/releases"))
            val snapshotsRepoUrl = uri(System.getProperty("REPOSITORY_URL_SNAPSHOT", "$buildDir/repos/snapshots"))
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }
}
