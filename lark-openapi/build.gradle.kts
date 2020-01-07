plugins {
  id("io.spring.dependency-management")
  id("org.springframework.boot")
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

  // API Doc
  implementation("cn.huitek.pete:pete-core")
  implementation("cn.huitek.pete:pete-swagger")
}

