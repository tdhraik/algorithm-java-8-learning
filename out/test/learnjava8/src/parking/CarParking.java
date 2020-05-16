package parking;

public class CarParking implements Parking {

    private final Double chargesPerVehicle = 10.50;

    private final Integer maximumSlots = 500;

    private Integer occupiedSlots;

    @Override
    public Integer getMaximumSlots() {
        return this.maximumSlots;
    }

    @Override
    public Integer getAvailableSlots() {
        System.out.println("Car");
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
        if(slotsToBook>0 && slotsToBook<=getAvailableSlots()) {
            this.occupiedSlots = this.occupiedSlots + slotsToBook;
        }
    }

    @Override
    public void releaseSlots(Integer slotsToRelease) {
        if(slotsToRelease>0 && this.occupiedSlots > slotsToRelease) {
            this.occupiedSlots = this.occupiedSlots - slotsToRelease;
        }
    }
}
