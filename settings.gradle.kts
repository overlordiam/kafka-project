pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.0"
    }
}
rootProject.name = "kafka-project"
include("producer-wikimedia")
include("consumer-opensearch")
