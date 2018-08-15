import java.util.*;

public interface Vehicle {
    Map<String,String> getVehiclePropertiesInfo();
    String getVehicleRegNo();
    boolean matchProperties(Map<String,String> vehiclePropertiesToMatch);
}
