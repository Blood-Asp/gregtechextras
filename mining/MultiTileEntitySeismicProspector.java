package bloodasp.gregtechextras.mining;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import gregapi.block.multitileentity.IMultiTileEntity;
import gregapi.data.CS;
import gregapi.data.LH;
import gregapi.old.Textures;
import gregapi.render.BlockTextureMulti;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.tileentity.TileEntityBase6;
import gregapi.util.UT;
import gregapi.render.BlockTextureDefault;

public class MultiTileEntitySeismicProspector extends TileEntityBase6 implements IMultiTileEntity.IMTE_RemovedByPlayer, IMultiTileEntity.IMTE_OnBlockActivated, IMultiTileEntity.IMTE_AddToolTips {

	boolean ready = false;
	
	 public static IIconContainer[] sColoreds = { new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/colored/bottom"), new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/colored/top"), new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/colored/side") };
	  public static IIconContainer[] sOverlays = { new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/overlay/bottom"), new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/overlay/top"), new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/overlay/side") };
	  public static IIconContainer sBarometer = new Textures.BlockIcons.CustomIcon("machines/overlays/barometer/Base");  

	@Override
	public ITexture getTexture2(Block arg0, int arg1, byte arg2) {
		return new BlockTextureMulti(new ITexture[] { new BlockTextureDefault(sColoreds[CS.FACES_TBS[2]], 16342215), new BlockTextureDefault(sOverlays[CS.FACES_TBS[2]]),  new BlockTextureDefault(sColoreds[2]), new BlockTextureDefault(sColoreds[1], CS.CA_RED_64) });
	}

	@Override
	public boolean canDrop(int arg0) {
		return true;
	}

	@Override
	public String getTileEntityName() {
		return "gte.multitileentity.seismicprospector";
	}

	@Override
	public boolean removedByPlayer(World arg0, EntityPlayer arg1, boolean arg2) {
		return this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public void addToolTips(List aList, ItemStack arg1, boolean arg2) {
		aList.add(LH.Chat.DGREEN + "Test1");// LH.get("gt.lang.hazard.explosion.steam"));
		aList.add(LH.Chat.DRED + "Test2");// LH.get("gt.lang.hazard.meltdown"));
	}

	@Override
	public boolean onBlockActivated(EntityPlayer aPlayer, byte aSide, float aHitX, float aHitY, float aHitZ) {
		if (isServerSide()) {
			ItemStack aStack = aPlayer.getCurrentEquippedItem();
			if ((aStack != null) && aStack.getItem() == Item.getItemFromBlock(Blocks.tnt) && aStack.stackSize > 31) {
				if ((!aPlayer.capabilities.isCreativeMode) && (aStack.stackSize != 111)) {
						aStack.stackSize -= 32;
				}
				this.ready = true;
			} else if (ready && aStack == null) {
				this.ready=false;
				System.out.println("give book");
//				aPlayer.inventory.addItemStackToInventory(UT.Stacks.getWrittenBook("Testbook", "Seismic Ore Scan", "Seismic Prospector", new String[] { "Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7", "Test8" }));
			} else{this.ready = false;}
		}
		
		return true;
	}
}
