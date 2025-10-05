package io.github.terickson87.ModulithWithUsersStarter

import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import kotlin.test.Test

class DocumentationTests {
    private val modules = ApplicationModules.of(Application::class.java)

    @Test
    fun writeDocumentationSnippets() {
        Documenter(modules)
            .writeModulesAsPlantUml()
            .writeIndividualModulesAsPlantUml()
    }
}