import java.util.Map;

public class ParkingLotSlotsStatus {
    Map<Integer, Vehicle> slotStatus;
    public ParkingLotSlotsStatus(Map<Integer, Vehicle> slotStatus)
    {
        this.slotStatus=slotStatus;
    }
    void printStatus()
    {
        System.out.println("Slot No\tRegistration No\tColour");
        for(Map.Entry<Integer, Vehicle> entry: slotStatus.entrySet())
        {
            Vehicle v = entry.getValue();
            System.out.println(entry.getKey()+"\t\t"+v.getVehicleRegNo()+"\t\t"+v.getVehiclePropertiesInfo().get(VehicleProperties.COLOR.name()));
        }
    }

}
