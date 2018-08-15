import java.util.*;
class Car implements Vehicle
{
    String regNo;
    Map<String,String> carProperties;
    Car(String regNo,Map<String,String> carProperties)
    {
        this.regNo = regNo;
        this.carProperties=carProperties;
    }
    Map<String,String> getVehicleInfo(String regNo){return carProperties;}


    @Override
    public Map<String,String> getVehiclePropertiesInfo() {
        return carProperties;
    }


    @Override
    public String getVehicleRegNo() {
        return regNo;
    }

    @Override
    public boolean matchProperties(Map<String, String> vehiclePropertiesToMatch) {
        for(Map.Entry<String,String> entry: vehiclePropertiesToMatch.entrySet())
        {
            if(carProperties.containsKey(entry.getKey())==false)
            {
                return false;//If for any reason the property we are looking for is not present at all we would return false
            }
            if((carProperties.containsKey(entry.getKey())) //If we have that property and it is not matching we obviously return false
                    && (carProperties.get(entry.getKey()).equalsIgnoreCase(entry.getValue())==false)
                    )
            {
                return false;
            }
        }
        //If we have reached here we would return true
        return true;
    }
}
