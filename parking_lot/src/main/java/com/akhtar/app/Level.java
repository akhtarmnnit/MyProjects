import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Level {
    int level;
    List<Slot> listOfSlots;
    int numEmptySlot;
    Map<String,String> LevelProperties;//All the properties that can define this level
    Level(int level, int slots)
    {
        this.level = level;
        this.listOfSlots = new ArrayList<Slot>(slots);
        int slotID=1;
        for(int i=0;i<slots;i++)
        {
            listOfSlots.add(new Slot(level,slotID++));
        }
        numEmptySlot=listOfSlots.size();//Initialize with this number
    }
    int getNumEmptySlot()
    {
        return numEmptySlot;
    }
    void addSlot(Slot s)
    {
        listOfSlots.add(s);
        numEmptySlot++;
    }
    Slot parkVehicleAtThisLevel(Vehicle c) throws Exception
    {
        for(Slot thisSlot:listOfSlots)
        {
            if(thisSlot.currentCarInSlot==null)
            {
                thisSlot.currentCarInSlot = c.getVehicleRegNo();
                numEmptySlot--;
                return thisSlot;
            }

        }
        throw new Exception("No empty slot available at this level");
    }
}
