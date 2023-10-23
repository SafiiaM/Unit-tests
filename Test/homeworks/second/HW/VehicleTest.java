package homeworks.second.HW;

import homeworks.second.HW.Car;
import homeworks.second.HW.Motorcycle;
import homeworks.second.HW.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp(){
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Ducati", "PANIGALE V4 R", 2023);
    }


    @Test
    void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    void testCarHaveForeWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void testMotorcycleHaveTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void testCatSpeedTestDrive(){
        car.testDrive();

        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void testMotoSpeedTestDrive(){
        motorcycle.testDrive();

        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void parkingCare() {
        car.testDrive();
        car.park();

        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void parkingMoto() {
        motorcycle.testDrive();
        motorcycle.park();

        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}