package bartboy8.servermanagementgui.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(new Listeners(this), this);
	}
	
	public void onDisable(){}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("smgui") || cmd.getName().equalsIgnoreCase("servergui") || cmd.getName().equalsIgnoreCase("servermanagement"))
		{
			Inventory smGUI = Inventorys.createInventory(player, 9, ChatColor.BLACK+""+ChatColor.UNDERLINE+""+ChatColor.BOLD+"Server Management:");
			smGUI.setItem(1, Inventorys.createItem(Material.LAVA_BUCKET, ChatColor.GOLD+""+ChatColor.UNDERLINE+""+ChatColor.BOLD+"Ban Player", multiLine(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"Bringin' down the hammer!","","","")));
			smGUI.setItem(3, Inventorys.createItem(Material.WATER_BUCKET, ChatColor.GOLD+""+ChatColor.UNDERLINE+""+ChatColor.BOLD+"Un-Ban Player", multiLine(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"Being nice I see..","","","")));
			smGUI.setItem(5, Inventorys.createItem(Material.DIAMOND_BOOTS, ChatColor.GOLD+""+ChatColor.UNDERLINE+""+ChatColor.BOLD+"Kick Player", multiLine(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"Give em' the boot!","","","")));
			smGUI.setItem(7, Inventorys.createItem(Material.DIAMOND_SWORD, ChatColor.GOLD+""+ChatColor.UNDERLINE+""+ChatColor.BOLD+"Kill Player", multiLine(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"I WILL FIND YOU, AND KILL YOU!","","","")));
			player.openInventory(smGUI);
		}
		return false;
	}
	
	public List<String> multiLine(String line1,String line2, String line3, String line4)
	{
		List<String> list = new ArrayList<String>();
		if(line1 != "" && line2 != "" && line3 != "" && line4 != "")
		{
			list.add(line1);
			list.add(line2);
			list.add(line3);
			list.add(line4);
			return list;
		}else
			if(line1 != "" && line2 != "" && line3 != "")
			{
				list.add(line1);
				list.add(line2);
				list.add(line3);
				return list;
			}else
				if(line1 != "" && line2 != "")
				{
					list.add(line1);
					list.add(line2);
					return list;
				}else
					if(line1 != "")
					{
						list.add(line1);
						return list;
					}
		return null;
	}

}
