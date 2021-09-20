package patches.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a vcsRoot with absolute id = 'ASecondaryNodeProject_MainConfigVcsTests'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, GitVcsRoot({
    id = AbsoluteId("ASecondaryNodeProject_MainConfigVcsTests")
    name = "Main config  VCS (tests)"
    url = "https://github.com/iyanke/tests"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "iyanke"
        password = "credentialsJSON:9aa8bfcd-5747-4645-9443-ff14596c8bee"
    }
}))

