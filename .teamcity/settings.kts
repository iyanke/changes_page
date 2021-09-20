import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.ProjectReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.projectReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.1"

project {

    vcsRoot(MainConfigVcsTests)

    buildType(ConfigFromMainNode)
    buildType(WithMetaruner)
    buildType(FromMetarunner)
    buildType(ConfigFromMainNodeCopiedOTheSecondNode)
    buildType(A)

    params {
        param("ccccccccccwwwwwwwwwwwwwwhhhhhhhhhh", "c")
    }

    features {
        projectReportTab {
            id = "PROJECT_EXT_80"
            title = "vccccccc"
            startPage = "index.html"
            buildType = "${ConfigFromMainNode.id}"
            sourceBuildRule = ProjectReportTab.SourceBuildRule.LAST_SUCCESSFUL
        }
    }
}

object A : BuildType({
    name = "A"
    description = "Build configuration created from meta-runner meta"

    steps {
        script {
            scriptContent = "echo metarunner"
        }
    }
})

object ConfigFromMainNode : BuildType({
    name = "Config from main node"

    vcs {
        root(MainConfigVcsTests)
    }
})

object ConfigFromMainNodeCopiedOTheSecondNode : BuildType({
    name = "Config from main node copied o the second node"

    vcs {
        root(MainConfigVcsTests)
    }

    steps {
        script {
            name = "Secondary"
            scriptContent = "echo main111"
        }
        script {
            name = "xxxxx"
            scriptContent = "secondt"
        }
        script {
            scriptContent = "echo main"
        }
        script {
            scriptContent = "call test.cmd"
        }
    }
})

object FromMetarunner : BuildType({
    name = "From metarunner"
    description = "Build configuration created from meta-runner meta"

    steps {
        script {
            scriptContent = "echo metarunner"
        }
    }
})

object WithMetaruner : BuildType({
    name = "With metaruner"

    steps {
        step {
            name = "metarun"
            type = "meta"
        }
        step {
            type = "ASecondaryNodeProject_ConfigFromMainNodeCopiedOTheSecondNode"
        }
    }
})

object MainConfigVcsTests : GitVcsRoot({
    name = "Main config  VCS (tests)"
    url = "https://github.com/iyanke/tests"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "iyanke"
        password = "credentialsJSON:9aa8bfcd-5747-4645-9443-ff14596c8bee"
    }
})
