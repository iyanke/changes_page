package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with absolute id = 'ASecondaryNodeProject_FromMetarunner'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, BuildType({
    id = AbsoluteId("ASecondaryNodeProject_FromMetarunner")
    name = "From metarunner"
    description = "Build configuration created from meta-runner meta"
    paused = true

    steps {
        script {
            scriptContent = "echo metarunner"
        }
    }
}))

