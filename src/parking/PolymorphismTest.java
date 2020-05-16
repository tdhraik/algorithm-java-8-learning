package parking;

public class PolymorphismTest {

    public static void main(String[] args) {

        Parking parking = new CarParking();
        Parking parking_2 = new BikeParking();
        parking.getAvailableSlots();
        parking_2.getAvailableSlots();
    }
}
