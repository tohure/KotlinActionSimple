# KotlinActionSimple
Base project to build your Actions on Google FulFillment completely in Kotlin

# Setup
Change your PROJECT ID in the build.gradle.kts file.

appengine {
    deploy {
        projectId = "YOUR_PROJECT_ID"
        version = "1"
        stopPreviousVersion = true
        promote = true
    }
}

# Deploy
Just run in your command line:
gradle appengineDeploy

# Don't forget
You must have installed and initialized gcloud
