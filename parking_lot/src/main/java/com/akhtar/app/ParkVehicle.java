//Concrete Command
public class ParkVehicle implements ParkingCommands{
    //reference to the light
    ParkingLot parkingLot;
    Vehicle v;
    public ParkVehicle(ParkingLot parkingLot, Vehicle v){
        this.v=v;
        this.parkingLot = parkingLot;
    }
    public void execute(){
        try {
            parkingLot.park(v);
        }
        catch (Exception ex)
        {
            
        }
    }
}