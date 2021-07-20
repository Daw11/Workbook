package ires.patterns.factorybuilder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class VehicleBuilderTest {
    @Test
    void given2WheelsWhenBuildThenShouldReturnNewMotorbike() {
        int wheels = 1;

        Vehicle result = VehicleBuilder.build( wheels );

        assertThat( result instanceof Motorbike );
    }

    @Test
    void given4WheelsWhenBuildThenShouldReturnNewCar() {
        int wheels = 4;

        Vehicle result = VehicleBuilder.build( wheels );

        assertThat( result instanceof Car );
    }

    @Test
    void given6WheelsWhenBuildThenShouldReturnNewTruck() {
        int wheels = 6;

        Vehicle result = VehicleBuilder.build( wheels );

        assertThat( result instanceof Truck );
    }

    @Test
    void givenWrongWheelsWhenBuildThenShouldReturnNull() {
        int wheels = 10000;

        Vehicle result = VehicleBuilder.build( wheels );

        assertThat( result ).isEqualTo( null );
    }
}