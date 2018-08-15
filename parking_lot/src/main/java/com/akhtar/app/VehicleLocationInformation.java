import java.util.*;
public class VehicleLocationInformation {
    //No matter how big a parking lot it cannnot have millions of cars or slots to park. Have an inverse mapping is ok from space consraint
    private Map<String, Slot> vehicleVsSlotMap;

    public Map<String, Slot> getVehicleVsSlotMap() {
        return vehicleVsSlotMap;
    }

    public Map<Integer, Vehicle> getSlotVsVehicleMap() {
        return slotVsVehicleMap;
    }

    private Map<Integer, Vehicle> slotVsVehicleMap;
    VehicleLocationInformation()
    {
        vehicleVsSlotMap = new HashMap<String, Slot>();
        slotVsVehicleMap = new HashMap<Integer, Vehicle>();
    }
    public void addVehicleLocationInformation(Vehicle v,Slot location)
    {
        vehicleVsSlotMap.put(v.getVehicleRegNo(),location);
        slotVsVehicleMap.put(location.slotNo,v);
    }
    public Slot getLocationOfVehicle(String carRegNo)
    {
        return vehicleVsSlotMap.get(carRegNo);
    }
    public Vehicle getVehicleInformationInSlot(Slot slot)
    {
        return slotVsVehicleMap.get(slot.slotNo);
    }
}
