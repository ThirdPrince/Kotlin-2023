import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.6.10"
    //application
}

group = "me.dhl"
version = "1.0-SNAPSHOT"

repositories {
    maven(url="https://mirrors.tencent.com/nexus/repository/maven-public/")
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    //implementation("com.bennyhuo.java:portable-android-handler:0.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.6.4")
    implementation("com.squareup.retrofit2:retrofit:2.7.0")
    implementation("com.squareup.retrofit2:converter-gson:2.7.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.14.2")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xallow-result-return-type", "-Xallow-kotlin-package")
        }
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}