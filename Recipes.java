package bloodasp.gregtechextras;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityClassContainer;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.CS.ModIDs;
import gregapi.network.IPacket;
import gregapi.network.NetworkHandler;
import gregapi.oredict.OreDictMaterial;
import gregapi.recipes.GT_ModHandler;
import gregapi.recipes.Recipe;
import gregapi.util.UT;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import bloodasp.gregtechextras.armor.ElectricModularArmor1;
import bloodasp.gregtechextras.armor.FluidSync;
import bloodasp.gregtechextras.armor.FluidSync2;
import bloodasp.gregtechextras.armor.ModularArmor_Item;
import bloodasp.gregtechextras.armor.Values;
import bloodasp.gregtechextras.mining.MultiTileEntitySeismicProspector;
import bloodasp.gregtechextras.tank.BlockTank;
import bloodasp.gregtechextras.tank.TileTank;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {


	public static Item modularBasicHelmet;
	public static Item modularBasicChestplate;
	public static Item modularBasicLeggings;
	public static Item modularBasicBoots;
	public static Item modularElectric1Helmet;
	public static Item modularElectric1Chestplate;
	public static Item modularElectric1Leggings;
	public static Item modularElectric1Boots;
	public static Item modularElectric2Helmet;
	public static Item modularElectric2Chestplate;
	public static Item modularElectric2Leggings;
	public static Item modularElectric2Boots;
	public static MultiTileEntityRegistry mter;
	
	public static void initRecipes(){

//		if(FMLCommonHandler.instance().getSide().isClient()){
//			tank = new RenderTank();
//		}
		mter = new MultiTileEntityRegistry("gte.multitileentity");
		
				new Values();
				modularBasicHelmet = new ModularArmor_Item(0, 0, "modulararmor_helmet",0);
				modularBasicChestplate = new ModularArmor_Item(0, 1, "modulararmor_chestplate",0);
				modularBasicLeggings = new ModularArmor_Item(0, 2, "modulararmor_leggings",0);
				modularBasicBoots = new ModularArmor_Item(0, 3, "modulararmor_boots",0);
				modularElectric1Helmet = new ElectricModularArmor1(0, 0, "modularelectric1_helmet",1);
				modularElectric1Chestplate = new ElectricModularArmor1(0, 1, "modularelectric1_chestplate",1);
				modularElectric1Leggings = new ElectricModularArmor1(0, 2, "modularelectric1_leggings",1);
				modularElectric1Boots = new ElectricModularArmor1(0, 3, "modularelectric1_boots",1);
				modularElectric2Helmet = new ElectricModularArmor1(0, 0, "modularelectric2_helmet",2);
				modularElectric2Chestplate = new ElectricModularArmor1(0, 1, "modularelectric2_chestplate",2);
				modularElectric2Leggings = new ElectricModularArmor1(0, 2, "modularelectric2_leggings",2);
				modularElectric2Boots = new ElectricModularArmor1(0, 3, "modularelectric2_boots",2);
		// new GTE_Multi_Tank(3584, "multimachine.tank",
		// "GTE Multi Tank").getStackForm(1L);
		// ClientRegistry.bindTileEntitySpecialRenderer(TileTank.class, new
		// RenderTank());
		GameRegistry.registerBlock(new BlockTank(), "blocktank");
		GameRegistry.registerTileEntity(TileTank.class, "tileTank");
		long bits =  GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;
		
		
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularBasicHelmet, 1, 32767), 		bits, new Object[] { "AAA", "B B", 'A', 		new ItemStack(Items.leather, 1, 32767), 'B', "ringAnyMetal"} );
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularBasicChestplate, 1, 32767), 	bits, new Object[] { "A A", "BAB", "AAA", 'A', 	new ItemStack(Items.leather, 1, 32767), 'B', "ringAnyMetal"} );
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularBasicLeggings, 1, 32767), 		bits, new Object[] { "BAB", "A A", "A A", 'A', 	new ItemStack(Items.leather, 1, 32767), 'B', "ringAnyMetal"} );
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularBasicBoots, 1, 32767), 		bits, new Object[] { "A A", "B B", "A A", 'A', 	new ItemStack(Items.leather, 1, 32767), 'B', "ringAnyMetal"} );
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularElectric1Helmet, 1, 32767), 	bits, new Object[] { "ACA", "B B", 'A', 		"stickAluminium", 'B', "plateSteel", 'C', "batteryAdvanced"});
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularElectric1Chestplate, 1, 32767),bits, new Object[] { "A A", "BCB", "AAA",'A', 	"stickAluminium", 'B', "plateSteel", 'C', "batteryAdvanced"});
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularElectric1Leggings, 1, 32767), 	bits, new Object[] { "BCB", "A A", "A A", 'A', 	"stickAluminium", 'B', "plateSteel", 'C', "batteryAdvanced"});
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularElectric1Boots, 1, 32767), 	bits, new Object[] { "A A", "BCB", "A A", 'A', 	"stickAluminium", 'B', "plateSteel", 'C', "batteryAdvanced"});
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularElectric2Helmet, 1, 32767), 	bits, new Object[] { "ACA", "B B", 'A', 		"stickTungstensteel", 'B', "plateAlloyCarbon",'C',"batteryMaster"});
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularElectric2Chestplate, 1, 32767),bits, new Object[] { "A A", "BCB", "AAA", 'A', 	"stickTungstensteel", 'B', "plateAlloyCarbon",'C',"batteryMaster"});
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularElectric2Leggings, 1, 32767), 	bits, new Object[] { "BCB", "A A", "A A", 'A', 	"stickTungstensteel", 'B', "plateAlloyCarbon",'C',"batteryMaster"});
		GT_ModHandler.addCraftingRecipe(new ItemStack(modularElectric2Boots, 1, 32767), 	bits, new Object[] { "A A", "BCB", "A A", 'A', 	"stickTungstensteel", 'B', "plateAlloyCarbon",'C',"batteryMaster"});

		
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(ModIDs.IC2, "itemArmorNanoHelmet", 1, 0));
		
	    MultiTileEntityBlock tMachineNonFull = MultiTileEntityBlock.getOrCreate("machine", MaterialMachines.instance, Block.soundTypeMetal, "wrench", 0, 0, 15, false, false);
		long tBits = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE;
		
		OreDictMaterial tMat = MT.Steel;GT_ModHandler.addCraftingRecipe(mter.add("Seismic Prospector","GTExtras", new MultiTileEntityClassContainer(0, 0, MultiTileEntitySeismicProspector.class, 1, 16, tMachineNonFull, UT.NBT.getNBTs(null, new Object[] { "gt.hardness", Float.valueOf(4.0F), "gt.resistance", Float.valueOf(4.0F), "gt.color", Integer.valueOf(UT.Code.getRGBInt(tMat.mRGBaSolid))}))), tBits, new Object[] { "PPP", "PwP", "BBB", Character.valueOf('B'), new ItemStack(Blocks.brick_block, 1), Character.valueOf('P'), OP.plate.get(tMat)});
	
	}
	
	
}
