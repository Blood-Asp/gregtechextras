package bloodasp.gregtechextras;
import bloodasp.gregtechextras.armor.ContainerBasicArmor;
import bloodasp.gregtechextras.armor.ContainerElectricArmor1;
import bloodasp.gregtechextras.armor.InventoryArmor;
import bloodasp.gregtechextras.armor.ModularArmor_Item;
import bloodasp.gregtechextras.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case 0:
			return new ContainerBasicArmor(player, new InventoryArmor(ModularArmor_Item.class, player.getCurrentEquippedItem()));
		case 1:
			return new ContainerElectricArmor1(player, new InventoryArmor(ModularArmor_Item.class, player.getCurrentEquippedItem()));
		case 2:
			return new ContainerElectricArmor1(player, new InventoryArmor(ModularArmor_Item.class, player.getCurrentEquippedItem()));
		default:
			return getRightItem(player, ID);
		}
	}
	
	public Object getRightItem(EntityPlayer player, int ID){
		ItemStack mStack = player.getEquipmentInSlot(ID/100);
		if(mStack==null||!(mStack.getItem() instanceof ModularArmor_Item))return null;
		
		switch(ID % 100){
		case 0:
			return new ContainerBasicArmor(player, new InventoryArmor(ModularArmor_Item.class, mStack));
		case 1:
			return new ContainerElectricArmor1(player, new InventoryArmor(ModularArmor_Item.class, mStack));
		case 2:
			return new ContainerElectricArmor1(player, new InventoryArmor(ModularArmor_Item.class, mStack));
		}
		return null;

	}
}