
group = "com.larkea"
version = "1.0.0-SNAPSHOT"

subprojects {
  apply(plugin = "java")
  apply(from="${rootProject.projectDir}/gradle/quality.gradle.kts")
  apply(from="${rootProject.projectDir}/gradle/publish.gradle.kts")

  configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(arrayOf("-Xlint:unchecked", "-Xlint:deprecation"))
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }

//  ext {
//    set("peteVersion", "1.0.23-SNAPSHOT")
//    set("springBootVersion", "2.2.2.RELEASE")
//  }

  repositories {
    mavenLocal()
    maven(url = "https://maven.huitong-tech.com/snapshots/")
    mavenCentral()
  }
}


