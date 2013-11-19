package bartboy8.servermanagementgui.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Listeners implements Listener {

	Main plugin;
	public Listeners(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void invClick(InventoryClickEvent event)
	{
		if(event.getInventory().getTitle().contains("Server Management:"))
		{
			if(event.getRawSlot() == 1)
			{
				
			}
			if(event.getRawSlot() == 3)
			{
				
			}
			if(event.getRawSlot() == 5)
			{
				
			}
			if(event.getRawSlot() == 7)
			{
				
			}
		}
	}
}
