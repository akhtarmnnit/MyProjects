import java.util.*;

public class CarParkingLot implements ParkingLot{
    List<Level> listOfParkingLevels;
    VehicleLocationInformation vehicleLocationInfo;
    Map<String,String> listOfParkingLotProperties;//Open ended properties map for any parking lot specific properties
    void addParkingProperty(String key,String value)
    {
        listOfParkingLotProperties.put(key,value);
    }
    CarParkingLot(int numLevels,int slots)
    {
        listOfParkingLevels = new ArrayList<Level>(numLevels);
        for(int i=0;i<numLevels;i++) {
            Level l = new Level(i,slots);
            listOfParkingLevels.add(l);
        }
        vehicleLocationInfo = new VehicleLocationInformation();
        listOfParkingLotProperties = new HashMap<String, String>();
    }
    int getAvailableSlotsForThisLevel(int level)
    {
        return listOfParkingLevels.get(level).getNumEmptySlot();
    }

    @Override
    public String park(Vehicle car) throws Exception
    {
        //Major method that would ensure the car is parked and its location returned. The Slot ID to be used as receipt
        //Decide for the algorithm to park the car.
        //Brute force method is to start from level 0 and move level to level for an empty slot
        Slot slot = parkBottomToTop(car);
        String StringToRetrun = "";
        if(slot==null) {
            StringToRetrun = "Sorry, parking lot is full";
        }
        else {
            StringToRetrun = "Allocated slot number:" + slot.slotNo;
        }
        System.out.println(StringToRetrun);
        return StringToRetrun;
    }


    public Slot parkBottomToTop(Vehicle v) throws Exception {
        for(Level currentLevel:listOfParkingLevels)
        {
            if(currentLevel.getNumEmptySlot()>0) {
                Slot slotInfo = currentLevel.parkVehicleAtThisLevel(v);
                vehicleLocationInfo.addVehicleLocationInformation(v,slotInfo);
                return slotInfo;
            }

        }
        return null;
    }

    @Override
    public String unParkAtSlot(int slotNo) {
        Vehicle v = vehicleLocationInfo.getSlotVsVehicleMap().get(slotNo);
        Slot s = vehicleLocationInfo.getVehicleVsSlotMap().remove(v.getVehicleRegNo());
        vehicleLocationInfo.getSlotVsVehicleMap().remove(s.slotNo);
        s.currentCarInSlot=null;//Mark the slot empty
        String stringToReturn = "Slot number "+slotNo+" is free";
        int level = s.levelOfThisSlot;
        listOfParkingLevels.get(level).addSlot(s);
        System.out.println(stringToReturn);
        return stringToReturn;
    }

    @Override
    public ParkingLotSlotsStatus getStatus() {
        return new ParkingLotSlotsStatus(vehicleLocationInfo.getSlotVsVehicleMap());
    }

    @Override
    public Vehicle getVehicleDetailsForRegno(String regNo) {
        return null;
    }

    @Override
    public Slot getSlotDetailsForVehicleWithRegno(String regNo) {
        return vehicleLocationInfo.getLocationOfVehicle(regNo);
    }

    @Override
    public Vehicle getVehicleDetailsForSlot(int slotNo) {
        return vehicleLocationInfo.getVehicleInformationInSlot(new Slot(0,slotNo));
    }

    @Override
    public List<Vehicle> getVehicleDetailsWithProperties(Map<String, String> vehicleProperties) {
        //Brute force approach. Search each slot of the parking lot for the car which matches the properties
        List<Vehicle> listToOutput = new ArrayList<Vehicle>();
        for(Map.Entry<Integer,Vehicle> entry: vehicleLocationInfo.getSlotVsVehicleMap().entrySet())
        {
            if(entry.getValue().matchProperties(vehicleProperties))
            {
                listToOutput.add(entry.getValue());
            }
        }
        return listToOutput;
    }

    @Override
    public List<Slot> getVehicleLocationWithProperties(Map<String, String> vehicleProperties) {
        List<Slot> listOfSlots = new ArrayList<Slot>();
        if(vehicleProperties.containsKey(VehicleProperties.REG_NO.name()))
        {
            Slot s = getSlotDetailsForVehicleWithRegno(vehicleProperties.get(VehicleProperties.REG_NO.name()));
            if(s!=null)//Add to the list if it is found
            listOfSlots.add(s);
        }
        else
        {
            //Search for the vehicle with that property in all the slots
            for(Map.Entry<Integer,Vehicle> entry: vehicleLocationInfo.getSlotVsVehicleMap().entrySet())
            {
                if(entry.getValue().matchProperties(vehicleProperties))
                {
                    listOfSlots.add(vehicleLocationInfo.getVehicleVsSlotMap().get(entry.getValue().getVehicleRegNo()));
                }
            }
        }
        return listOfSlots;
    }
}
