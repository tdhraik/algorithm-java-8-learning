package parking;

public interface Parking {

    Integer getMaximumSlots();

    Integer getAvailableSlots();

    Integer getOccupiedSlots();

    Double getParkingChargesForOneVehicle();

    void bookSlots(Integer slotsToBook);

    void releaseSlots(Integer slotsToRelease);
}
