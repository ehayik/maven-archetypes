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
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Slf4j
@SpringJUnitConfig
class ApplicationIT {

    @Autowired
    private Environment environment;

    @BeforeEach
    void setUp() {
        log.info("Running integration test");
    }

    @Test
    void shouldReturnDefaultProfile() {
        // When
        var actualProfiles = environment.getDefaultProfiles();

        // Then
        assertThat(actualProfiles).contains("default");
    }
}
