plugins {
    kotlin("jvm") version "1.3.70"
    war
    id("com.google.cloud.tools.appengine") version "2.2.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.actions:actions-on-google:1.8.0")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("org.slf4j:slf4j-jdk14:1.7.28")
    providedCompile("javax.servlet:javax.servlet-api:4.0.1")
}

appengine {
    deploy {
        projectId = "YOUR_PROJECT_ID"
        version = "1"
        stopPreviousVersion = true
        promote = true
    }
}

val javaVersionCode = JavaVersion.VERSION_1_8.toString()

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = javaVersionCode
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = javaVersionCode
    }
}