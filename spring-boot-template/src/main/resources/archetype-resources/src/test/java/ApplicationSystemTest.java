#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Slf4j
@SystemTest
class ApplicationSystemTest {

    @Autowired
    private Environment environment;

    @BeforeEach
    void setUp() {
        log.info("Running system test");
    }

    @Test
    void shouldReturnExpectedMessage() {
        // When
        var actualMessage = environment.getProperty("app.message");

        // Then
        assertThat(actualMessage).isEqualTo("Hello World!");
    }
}
