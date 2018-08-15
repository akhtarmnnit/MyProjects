public class ParkingLotManager {
    static ParkingLot createParkingLot(int levels,int slotsPerLevel,int typeOfParkingLot)
    {
        return ParkingLotFactory.getParkingLot("CAR",levels,slotsPerLevel);
    }
}
