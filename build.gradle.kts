plugins {
    id("java")
}

group = "net.rorum.MongoHandlerWithMinecraft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mongodb:mongodb-driver-sync:4.10.1")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}


tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}