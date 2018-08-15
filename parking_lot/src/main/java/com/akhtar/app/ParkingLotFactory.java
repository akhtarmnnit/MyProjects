public class ParkingLotFactory {
    public static ParkingLot getParkingLot(String type, int levels,int slots ){
        if("CAR".equalsIgnoreCase(type))
        {
            return new CarParkingLot(levels,slots);
        }
        else {
            return null;
        }
    }
}