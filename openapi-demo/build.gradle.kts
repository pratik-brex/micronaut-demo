plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("org.jetbrains.kotlin.kapt") version "1.4.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.2.0"
}

version = "0.1"
group = "openapi.demo"

val kotlinVersion=project.properties.get("kotlinVersion")
val micronautVersion=project.properties.get("micronautVersion")
repositories {
    mavenCentral()
    jcenter()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("openapi.demo.*")
    }
}

dependencies {
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut:micronaut-inject")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut.openapi:micronaut-openapi")
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")
    kaptTest("io.micronaut:micronaut-inject-java")
    kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}


application {
    mainClass.set("openapi.demo.Api")
}

java {
    sourceCompatibility = JavaVersion.toVersion("1.8")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }


}

