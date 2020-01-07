plugins {
  id("io.spring.dependency-management")
}

dependencyManagement {
  val peteVersion = ext.get("peteVersion") as String
  val springBootVersion = ext.get("springBootVersion") as String
  imports {
    mavenBom("cn.huitek.pete:pete-dependencies:$peteVersion")
    mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
  }
}

dependencies {
  // Util
  annotationProcessor("org.projectlombok:lombok")
  implementation("org.projectlombok:lombok")
  implementation("io.github.openfeign:feign-core")
  implementation("io.github.openfeign:feign-jackson")
  implementation("io.github.openfeign:feign-slf4j")
  implementation("io.github.openfeign.form:feign-form")
  implementation("org.springframework.boot:spring-boot-starter")

  // Project
  implementation(project(":lark-openapi"))
}
