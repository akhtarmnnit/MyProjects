//Concrete Command
public class UnParkVehicle implements ParkingCommands{
    //reference to the light
    ParkingLot parkingLot;
    int slotNo;
    public UnParkVehicle(ParkingLot parkingLot,int slotNo){
        this.parkingLot = parkingLot;
        this.slotNo=slotNo;
    }
    @Override
    public void execute() {
        parkingLot.unParkAtSlot(slotNo);
    }
}