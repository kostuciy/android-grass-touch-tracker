pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Grass Touch Tracker"
include(":app")
include(":core")
include(":features")
include(":core:data")
include(":core:domain")
include(":core:ui")
include(":features:scan")
include(":features:useractivity")
include(":features:settings")
include(":features:map")
