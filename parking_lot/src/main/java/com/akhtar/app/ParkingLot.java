import java.util.*;
public interface ParkingLot {
    //Park a vehicle
    String park(Vehicle v) throws Exception;
    //Unpark the vehicle from a slot s
    String unParkAtSlot(int slotNo);
    //Get the current status of all the vehicles in parking lot
    ParkingLotSlotsStatus getStatus();
    //Keep this separate since Regno is unique key
    Vehicle getVehicleDetailsForRegno(String regNo);

    //Keep this separate as regNo is unique key
    Slot getSlotDetailsForVehicleWithRegno(String regNo);

    //Get the vehicle parked at a particular slot in this
    Vehicle getVehicleDetailsForSlot(int slotNo);

    //Generic API. Get all the vehicles which confirm to the properties provided like make,model,color etc
    List<Vehicle> getVehicleDetailsWithProperties(Map<String,String> vehicleProperties);

    //Generic API. Get all the Slots which confirm to the properties provided like make,model,color etc.
    List<Slot> getVehicleLocationWithProperties(Map<String,String> vehicleProperties);
}
