import java.util.*;
public class Slot {
    int slotNo;//A unique Id across the parking lot
    int levelOfThisSlot;
    Map<String,String> slotProperties;//Can have multiple information like block withint parking lot, lat long etc
    String currentCarInSlot;//null means empty slot
    Slot(int level,int slotNo)
    {
        this.levelOfThisSlot=level;
        this.slotNo=slotNo;
    }
    String getSlotInfo()
    {
        return "SlotNo="+slotNo+"Level="+levelOfThisSlot;
    }
}
