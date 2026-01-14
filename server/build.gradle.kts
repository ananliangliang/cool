plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.serialization)
}

group = "io.github.ananliangliang.cool"
version = "1.0.0"
application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)

    implementation(libs.bundles.exposed)
    implementation(libs.bundles.ktor.server)
    implementation(libs.koin.ktor)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.postgresql)
    implementation(libs.spring.security.crypto)
//    implementation(libs.spring.jcl)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}