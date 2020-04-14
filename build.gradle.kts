plugins {
    kotlin("jvm") version "1.3.71"
    id("net.minecrell.plugin-yml.bukkit") version "0.3.0"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "com.yourname"
version = "0.1.0-SNAPSHOT"

val spigot_version = "1.8.8-R0.1-SNAPSHOT"
val kotlinbukkitapi_version = "0.1.0-SNAPSHOT"

//val hikaricp_version = "3.4.1" // optional dependency
//val exposed_version = "0.21.1" // optional dependency

repositories {
    jcenter()

    // Spigot
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }

    // KotlinBukkitAPI
    maven { url = uri("http://nexus.devsrsouza.com.br/repository/maven-public/")}
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8")) // embedded in KotlinBukkitAPI

    compileOnly("org.spigotmc:spigot-api:$spigot_version")

    // KotlinBukkitAPI
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:core:$kotlinbukkitapi_version")
    compileOnly("br.com.devsrsouza.kotlinbukkitapi:architecture:$kotlinbukkitapi_version")
    //compileOnly("br.com.devsrsouza.kotlinbukkitapi:exposed:$kotlinbukkitapi_version")
    //compileOnly("br.com.devsrsouza.kotlinbukkitapi:plugins:$kotlinbukkitapi_version")

    // OPTIONAL EXTRA DEPENDENCIES

    // hikaricp
    //implementation("com.zaxxer:HikariCP:$hikaricp_version")

    // exposed
    //implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    //implementation("org.jetbrains.exposed:exposed-java-jdbc:$exposed_version")
    //implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
}

bukkit {
    main = "${project.group}.${project.name.toLowerCase()}.${project.name}Plugin"
    author = "Your Name"
    website = "yourwebsite.com"
    depend = listOf("KotlinBukkitAPI")

    description = "The plugin description."
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    shadowJar {
        classifier = null
    }
}