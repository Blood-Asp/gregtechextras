package bloodasp.gregtechextras;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import bloodasp.gregtechextras.armor.ContainerBasicArmor;
import bloodasp.gregtechextras.armor.ContainerElectricArmor1;
import bloodasp.gregtechextras.armor.GuiElectricArmor1;
import bloodasp.gregtechextras.armor.GuiModularArmor;
import bloodasp.gregtechextras.armor.InventoryArmor;
import bloodasp.gregtechextras.armor.ModularArmor_Item;

public class ClientProxy extends CommonProxy{

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case 0:
			return new GuiModularArmor(new ContainerBasicArmor(player, new InventoryArmor(ModularArmor_Item.class, player.getCurrentEquippedItem())), player);
		case 1:
			return new GuiElectricArmor1(new ContainerElectricArmor1(player, new InventoryArmor(ModularArmor_Item.class, player.getCurrentEquippedItem())), player);
		case 2:
			return new GuiElectricArmor1(new ContainerElectricArmor1(player, new InventoryArmor(ModularArmor_Item.class, player.getCurrentEquippedItem())), player);
		default:
			return getRightItemGui(player, ID);
		}
	}
	
	public Object getRightItemGui(EntityPlayer player, int ID){
		ItemStack mStack = player.getEquipmentInSlot(ID/100);
		if(mStack==null||!(mStack.getItem() instanceof ModularArmor_Item))return null;
		
		switch(ID % 100){
		case 0:
			return new GuiModularArmor(new ContainerBasicArmor(player, new InventoryArmor(ModularArmor_Item.class, mStack)),player);
		case 1:
			return new GuiElectricArmor1(new ContainerElectricArmor1(player, new InventoryArmor(ModularArmor_Item.class, mStack)), player);
		case 2:
			return new GuiElectricArmor1(new ContainerElectricArmor1(player, new InventoryArmor(ModularArmor_Item.class, mStack)), player);
		}
		return null;

	}
}

