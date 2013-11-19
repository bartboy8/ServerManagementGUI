package bartboy8.servermanagementgui.main;

import java.util.List;

import net.minecraft.server.v1_6_R3.NBTTagCompound;
import net.minecraft.server.v1_6_R3.NBTTagList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_6_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventorys {
	
	public static Inventory createInventory(Player player, int slots, String invName){
		return Bukkit.getServer().createInventory(player, slots, invName);
	}
	
	public static boolean SingleslotListener(InventoryClickEvent event,String iTitle, int rawSlot)
	{
		if(event.getInventory().getTitle().contains(iTitle) && event.getRawSlot() == rawSlot){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean TwoslotListener(InventoryClickEvent event,String iTitle, int smallRawSlot, int bigRawSlot)
	{
		if(event.getInventory().getTitle().contains(iTitle) && event.getRawSlot() >= smallRawSlot && event.getRawSlot() <= bigRawSlot)
		{
			return true;
		}
		return false;
	}
	
	public static boolean itemSlotListener(InventoryClickEvent event, ItemStack clicked)
	{
		if(event.getInventory().getItem(event.getRawSlot()) == clicked)
		{
			return true;
		}
		return false;
	}
	
	public static ItemStack createItem(Material m, String displayName, List<String> lore)
	{
		ItemStack item = new ItemStack(m);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(displayName);
		im.setLore(lore);
		item.setItemMeta(im);
		item = addGlow(item);
		return item;
	}
	
    public static ItemStack addGlow(ItemStack item){ 
        net.minecraft.server.v1_6_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = null;
        if (!nmsStack.hasTag()) {
            tag = new NBTTagCompound();
            nmsStack.setTag(tag);
        }
        if (tag == null) tag = nmsStack.getTag();
        NBTTagList ench = new NBTTagList();
        tag.set("ench", ench);
        nmsStack.setTag(tag);
        return CraftItemStack.asCraftMirror(nmsStack);
    }

}
