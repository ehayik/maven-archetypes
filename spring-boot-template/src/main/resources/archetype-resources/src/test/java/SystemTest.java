#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Custom annotation used for system tests.
 *
 * <p>System tests are used to perform end-to-end testing of a system. They verify that
 * the entire system is working correctly by testing the interactions between its components.</p>
 *
 * <p>This annotation is used to mark a test class as a system test. When applied to a class,
 * it indicates that the class contains system-level tests.</p>
 *
 * <p>It is important to note that SystemTest is a meta-annotation, meaning that it is an
 * annotation that can be used as an annotation on other elements, such as classes.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 *
 * import lombok.extern.slf4j.Slf4j;
 *
 * {@literal @}Slf4j
 * {@literal @}SystemTest
 * class ApplicationSystemTest {
 *
 *     {@literal @}Autowired
 *     private Environment environment;
 *
 *     {@literal @}BeforeEach
 *     void setUp() {
 *         log.info("Running system test");
 *     }
 *
 *     {@literal @}Test
 *     void shouldReturnExpectedMessage() {
 *         // When
 *         var actualMessage = environment.getProperty("app.message");
 *
 *         // Then
 *         assertThat(actualMessage).isEqualTo("Hello World!");
 *     }
 * }
 * }</pre>
 */
@Inherited
@Documented
@Target(TYPE)
@Retention(RUNTIME)
@SpringBootTest(properties = "spring.main.banner-mode=off")
@ActiveProfiles("system-tests")
public @interface SystemTest {}
