# 🧭 Coding Standards for Java Spring Boot Backend API

## 1. 📦 Project Structure

Follow standard Maven/Gradle structure:

```
src/
 ├─ main/
 │   ├─ java/com/company/project/...
 │   ├─ resources/
 │   │   ├─ application.yml
 │   │   ├─ logback-spring.xml
 ├─ test/
     ├─ java/com/company/project/...
```

**Packages:**
```
com.company.project
 ├─ config
 ├─ controller
 ├─ service
 ├─ repository
 ├─ model/entity
 ├─ dto
 ├─ mapper
 ├─ exception
 ├─ util
```

---

## 2. 🧑‍💻 Code Style

- Follow **Google Java Style Guide** or **Spring Boot conventions**.
- Use **4 spaces** for indentation (no tabs).
- Max line length: **120 characters**.
- Use **UTF-8** encoding.
- Always include **Javadoc** for public classes and methods.
- Class names: `PascalCase` (e.g. `UserController`).
- Method and variable names: `camelCase` (e.g. `getUserDetails()`).
- Constants: `UPPER_CASE_WITH_UNDERSCORES`.

---

## 3. ⚙️ Spring Boot Conventions

### 3.1. Controllers
- Annotate with `@RestController`.
- Use clear and consistent request mappings:
  ```java
  @GetMapping("/users/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable Long id)
  ```
- Return `ResponseEntity<T>` always.
- Handle validation with `@Valid` and `@RequestBody`.
- Keep controllers **thin** — delegate logic to services.

### 3.2. Services
- Annotate with `@Service`.
- Contain business logic only.
- Avoid direct database access — use repositories.
- Use clear method names (e.g. `createUser`, `getActiveUsers`).

### 3.3. Repositories
- Annotate with `@Repository`.
- Extend `JpaRepository` or `CrudRepository`.
- Use derived query methods where possible:
  ```java
  List<User> findByStatus(String status);
  ```
- For complex queries, use `@Query`.

---

## 4. 🧱 Entities & DTOs

### Entities
- Annotate with `@Entity` and `@Table(name = "table_name")`.
- Use `@Column` for explicit column mapping.
- Prefer `Long` IDs with `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
- Avoid bi-directional relationships unless necessary.
- Override `equals()` and `hashCode()` carefully (use IDs if available).

### DTOs
- Keep DTOs separate from entities.
- Use them for input/output of APIs.
- Map entities ↔ DTOs using:
  - MapStruct (preferred)
  - or manual mappers.

---

## 5. 🔒 Exception Handling

- Use a global exception handler with `@ControllerAdvice`.
- Define custom exceptions (e.g. `UserNotFoundException`).
- Standardize error response:
  ```json
  {
    "timestamp": "2025-11-06T10:00:00Z",
    "status": 404,
    "error": "User Not Found",
    "message": "User with id 5 does not exist",
    "path": "/api/users/5"
  }
  ```

---

## 6. 🧪 Testing

- Use **JUnit 5** and **Mockito**.
- Each public method should have at least one unit test.
- For integration tests:
  - Use `@SpringBootTest`
  - Use in-memory DB (`H2`)
- Follow naming convention:  
  `ClassNameTest.java`  
  Example test method names:
  ```java
  shouldReturnUserWhenValidId();
  shouldThrowExceptionWhenUserNotFound();
  ```

---

## 7. 🧰 Logging & Monitoring

- Use **SLF4J** via Lombok:
  ```java
  @Slf4j
  public class UserService { ... }
  ```
- Log levels:
  - **INFO** – key business events  
  - **DEBUG** – detailed debugging info  
  - **ERROR** – exception cases only  
- Never log sensitive information (passwords, tokens).

---

## 8. 🧹 Clean Code Practices

- Keep methods **short** and **single-responsibility**.
- Use **Optional** instead of `null` where applicable.
- Use **Streams** and **Lambdas** judiciously — prefer readability.
- Add **TODO/FIXME** tags for follow-up items.
- Avoid magic numbers — define constants.
- Always clean unused imports.

---

## 9. 🔐 Security

- Validate all request payloads.
- Use Spring Security with roles/permissions.
- Externalize secrets (never commit them to Git).
- Sanitize user inputs to prevent injection attacks.
- Enable HTTPS and security headers in production.

---

## 10. 🚀 CI/CD & Code Quality

- Enforce code style using:
  - `spotless` or `checkstyle`
- Run tests via:
  - `mvn clean verify`
- Use static code analysis:
  - **SonarQube** or **Semgrep**
- Code coverage: **≥ 80%** recommended.

---

## 11. 📄 Documentation

- Maintain up-to-date **API documentation** with **SpringDoc OpenAPI**.
