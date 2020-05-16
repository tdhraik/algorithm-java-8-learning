package parking;

public class BikeParking implements Parking {

    private final Double chargesPerVehicle = 04.00;

    private final Integer maximumSlots = 100;

    private Integer occupiedSlots;

    @Override
    public Integer getMaximumSlots() {
        return this.maximumSlots;
    }

    @Override
    public Integer getAvailableSlots() {
        System.out.println("BIKE");
//        return this.maximumSlots - this.occupiedSlots;
        return 0;
    }

    @Override
    public Integer getOccupiedSlots() {
        return this.occupiedSlots;
    }

    @Override
    public Double getParkingChargesForOneVehicle() {
        return this.chargesPerVehicle;
    }

    @Override
    public void bookSlots(Integer slotsToBook) {
        this.occupiedSlots = this.occupiedSlots + slotsToBook;
    }

    @Override
    public void releaseSlots(Integer slotsToRelease) {
        this.occupiedSlots = this.occupiedSlots - slotsToRelease;
    }
}
