package ires.patterns.factorybuilder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class VehicleBuilderTest {

    @Test
    void given4WheelsWhenBuildThenShouldReturnNewCar() {
        int wheels = 4;
        Vehicle expectedResult = new Car();

        Vehicle result = VehicleBuilder.build( wheels );

        assertThat( result ).isEqualTo( expectedResult );
    }
}