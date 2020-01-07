apply(plugin = "findbugs")

tasks.withType<FindBugs> {
  source = fileTree("src/main/java/")
  classes = files("${project.buildDir}/classes")
  classpath = files()
  ignoreFailures = true
  effort = "max"
  showProgress = true
  reportLevel = "low"
  setExcludeFilter(file("${rootProject.projectDir}/gradle/quality/findbugs/excludeFilter.xml"))
  reports {
    xml.isEnabled = false
    html.isEnabled = true
    html.destination = file("${project.buildDir}/findbugsReports.html")
  }
}

