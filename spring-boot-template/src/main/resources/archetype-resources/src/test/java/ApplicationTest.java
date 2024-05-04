#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.core.env.Environment;

@Slf4j
@MockitoSettings
class ApplicationTest {

    @Mock
    private Environment environment;

    @BeforeEach
    void setUp() {
        log.info("Running unit test");
    }

    @Test
    void shouldReturnActiveProfile() {
        // Given
        given(environment.getActiveProfiles()).willReturn(new String[] {"prod"});

        // When
        var actualProfiles = environment.getActiveProfiles();

        // Then
        assertThat(actualProfiles).contains("prod");
    }
}
