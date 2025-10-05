# AI Coding Agent Instructions for ModulithWithUsersStarter

## Project Overview
ModulithWithUsersStarter is a modular monolith application designed to demonstrate best practices for building modular systems with Spring. The project emphasizes clear module boundaries, modularity, and scalability while maintaining simplicity.

### Key Components
- **Modules**: Each module is a self-contained unit with its own domain logic, services, and data access. Modules communicate via well-defined interfaces.
- **Spring Modulith**: Used to enforce modular boundaries and document the architecture.
- **PostgreSQL Database**: The application uses PostgreSQL databases hosted on Docker for persistence.
- **Message-Based Communication**: The application strives to use message-based asynchronous communication as much as possible to decouple modules.

### Major Directories
- `src/main/kotlin`: Contains the main application code.
- `src/test/kotlin`: Contains test cases for the application, including integration tests.
- `src/main/resources`: Stores configuration files and templates.
- `build/`: Contains build artifacts.

## Developer Workflows

### Building the Project
Use the Gradle wrapper to build the project:
```bash
./gradlew build
```

### Running Tests
Execute all tests, including integration tests, with:
```bash
./gradlew test
```
Test reports are generated in `build/reports/tests/test/index.html`.

### Running the Application
Start the application locally:
```bash
./gradlew bootRun
```

### Debugging
- Use the `application.properties` file in `src/main/resources` to configure logging levels.
- Test results and logs are stored in the `build/` directory.

## Project-Specific Conventions

### Modular Design
- Each module is a self-contained unit with its own domain logic, services, and data access.
- Modules communicate via well-defined interfaces.
- Use `@Module` annotations to define module boundaries.
- Favor message-based asynchronous communication to decouple modules.

### Testing
- The project uses **Kotest** for testing and **MockK** for mocking dependencies.
- Kotest's `BehaviorSpec` is used to structure test cases in a Given-When-Then style.
- Integration tests use **Testcontainers** to spin up PostgreSQL databases in Docker.
- Unit tests and integration tests are located in `src/test/kotlin`.
- Example of a BDD-style test:
  ```kotlin
  class UserServiceTest : BehaviorSpec({
      given("a user creation request") {
          `when`("the request is valid") {
              then("the user should be created successfully") {
                  // Test logic here
              }
          }
      }
  })
  ```

### Serialization
- The project uses **kotlinx.serialization** for serializing and deserializing DTOs in the controller layer.

### Security
- **Spring Security** is used for authentication and authorization.

### Code Style
- Prefer Kotlin **data classes** for immutable data structures.
- Use **scope functions** (`let`, `apply`, `run`, `also`, `with`) to simplify code and reduce boilerplate.
- Emphasize **immutability** and avoid mutable state where possible.
- Follow **functional programming paradigms**, such as using higher-order functions and avoiding side effects.
- Follow Kotlin conventions.
- Use meaningful names for classes, methods, and variables.
- Keep methods short and focused.

## Integration Points
- **Database**: Configured via `application.properties`. Uses PostgreSQL databases hosted on Docker.
- **External APIs**: Define clients in the `infrastructure` layer.
- **Spring Modulith**: Generates architecture documentation in `build/spring-modulith-docs/`.

## Examples

### Service Definition
```kotlin
@Service
class UserService {
    fun createUser(user: User): User {
        // Business logic here
    }
}
```

### Test Case
```kotlin
@Test
fun `should create user successfully`() {
    // given
    val user = User("John Doe")

    // when
    val result = userService.createUser(user)

    // then
    assertEquals("John Doe", result.name)
}
```

## Additional Notes
- Refer to `HELP.md` for more details on project setup.
- Use `settings.gradle.kts` to manage module dependencies.

---

Feel free to update this document as the project evolves.