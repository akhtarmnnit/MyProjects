import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        test1();
    }

    protected static void test1()
    {
        try {
            //create_parking_lot 6
            ParkingLot parkingLot = ParkingLotManager.createParkingLot(1, 6, 0);
            //park KA-01-HH-1234 White
            String result = parkingLot.park(new Car("KA-01-HH-1234", Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.WHITE.name());
                    }}) ));
            //System.out.println(result);
            //park KA-01-HH-9999 White
            String result1 = parkingLot.park(new Car("KA-01-HH-9999", Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.WHITE.name());
                    }}) ));
            //System.out.println(result1);
            //park KA-01-BB-0001 Black
            String result2 = parkingLot.park(new Car("KA-01-BB-0001", Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.BLACK.name());
                    }}) ));
            //System.out.println(result2);
            //park KA-01-HH-7777 Red
            String result3 = parkingLot.park(new Car("KA-01-HH-7777", Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.WHITE.name());
                    }}) ));
            //System.out.println(result3);
            //park KA-01-HH-2701 Blue
            String result4 = parkingLot.park(new Car("KA-01-HH-2701", Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.BLUE.name());
                    }}) ));
            //System.out.println(result4);
            //park KA-01-HH-3141 Black
            parkingLot.park(new Car("KA-01-HH-3141", Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.BLACK.name());
                    }}) ));
            //leave 4
            String result5 = parkingLot.unParkAtSlot(4);
            //status
            ParkingLotSlotsStatus status = parkingLot.getStatus();
            status.printStatus();
            //park KA-01-P-333 White
            parkingLot.park(new Car("KA-01-P-333", Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.WHITE.name());
                    }}) ));
            //park DL-12-AA-9999 White
            parkingLot.park(new Car("DL-12-AA-9999", Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.WHITE.name());
                    }}) ));
            //registration_numbers_for_cars_with_colour White
            List<Vehicle> vehicleList = parkingLot.getVehicleDetailsWithProperties(Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.WHITE.name());
                    }}) );
            for(Vehicle v:vehicleList)
            {
                System.out.print(v.getVehicleRegNo()+" ");
            }
            System.out.println();
            //slot_numbers_for_cars_with_colour White
            List<Slot> vehicleLocationInformation1 = parkingLot.getVehicleLocationWithProperties(Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.COLOR.name(), VehicleColor.WHITE.name());
                    }}) );
            for(int i=0;i<vehicleLocationInformation1.size();i++) {
                System.out.print(vehicleLocationInformation1.get(i).slotNo+" ");
            }
            System.out.println();
            //slot_number_for_registration_number KA-01-HH-3141
            List<Slot>  vehicleLocationInformation2
                    = parkingLot.getVehicleLocationWithProperties(Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.REG_NO.name(), "KA-01-HH-3141");
                    }}) );
            System.out.println(vehicleLocationInformation2.get(0).slotNo);
            //slot_number_for_registration_number MH-04-AY-1111
            List<Slot> vehicleLocationInformation3
                    = parkingLot.getVehicleLocationWithProperties(Collections.unmodifiableMap(
                    new HashMap<String, String>() {{
                        put(VehicleProperties.REG_NO.name(), "MH-04-AY-1111");
                    }}) );
            if(vehicleLocationInformation3.size()==0)
            {
                System.out.println("Not found");
            }
            else {
                System.out.println(vehicleLocationInformation3.get(0).slotNo);
            }
        }
        catch (Exception ex)
        {

        }
    }
}

