
import io.github.terickson87.ModulithWithUsersStarter.Application
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import kotlin.jvm.java
import kotlin.test.Test

internal class ModularityTests {
    var modules: ApplicationModules = ApplicationModules.of(Application::class.java)

    @Test
    fun verifiesArchitecture() {
        // System.out.println(modules);
        modules.verify()
    }

    @Test
    fun createDocumentation() {
        Documenter(modules).writeDocumentation()
    }
}