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
import gregtech.GT_Mod;
import bloodasp.gregtechextras.armor.ElectricModularArmor1;
import bloodasp.gregtechextras.armor.FluidSync;
import bloodasp.gregtechextras.armor.FluidSync2;
import bloodasp.gregtechextras.armor.ModularArmor_Item;
import bloodasp.gregtechextras.armor.Values;
import bloodasp.gregtechextras.mining.MultiTileEntitySeismicProspector;
import bloodasp.gregtechextras.tank.BlockTank;
import bloodasp.gregtechextras.tank.RenderTank;
import bloodasp.gregtechextras.tank.TankRenderCubeStatic;
import bloodasp.gregtechextras.tank.TileTank;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * @author Blood Asp
 *
 *Plans: 
 *
 *0.1 - Initial Release. Only partly working Modular Armor
 *
 *0.2 - Server side bug fixed
 *Armors now have special Radiation-, Electric-, Wither-, Fall-damage reduction
 *Thorns
 *Item Magnet
 *Tooltip infos added
 *Armors now do have durability. Once the durability is below 50% there is a chance of breaking Parts. Can be repaired with Leather on anvil.
 *
 *v0.2.1 - A few more server side bugfixes.
 *
 *v0.2.2 - Fixed dupebug
 *
 *v0.3.0 - Adding Electric Parts: Batteries, Motors, Pistons, Nightvision, ThaumicGoggels,  
 *		   Fluid Tanks in Armors, storing of potions
 *		   Adding Electric Tier I&II Armor
 *		   Changed data saving system
 *		   Slowdown now without potion effect, New Tool Materials
 *
 *v0.3.1 - Crafting recipes, more tool materials, many electric fixes, removed dev logging
 *
 *v0.3.3 - allow underwater breathing, more language entrys, first Hotkeys, New Gui
 *		
 *v0.4.0 - 3x3 Drill, Seismic ore scanner,Electrolyzer Upgrade,  Autofeeder, fluid food, Potion upgrade
 *
 *v0.5.0 - Field Generators, Jetpack, Configs, Disable IC2 Armors, portable naquadah generator, other generators
 *
 *v0.6.0+- After Cover in GT6: Needs Maintainance Cover, Wireless RS Cover, IC2 EU converter cover, Fluid window cover.
 *
 *			After Multiblock in GT6: Multi Fluid Tank, Multi Quantum Storage, Advanced Miner II, Oil derrick, distillation tower
 *
 *			Galacticraft features: Some recipes work only in space, SolarSatelites, Some lategame Ores only in space, Ion Cannon, 
 *		
 *			Minetweaker integration
 *
 */

@Mod(modid = GTExtras.MODID, version = GTExtras.VERSION, dependencies = GTExtras.dependencies)
public class GTExtras {
	public static final String MODID = "gtextras", dependencies = "required-after:gregtech; required-after:gregapi;";
	public static final String VERSION = "0.3.3";
	public static int renderID = -1;
	public static NetworkHandler NET;
	
	//public static RenderTank tank;
	@Mod.Instance
	public static GTExtras INSTANCE;
	@SidedProxy(clientSide = "bloodasp.gregtechextras.ClientProxy", serverSide = "bloodasp.gregtechextras.CommonProxy")
	public static CommonProxy proxy;
	

	@SideOnly(Side.CLIENT)
	public static int getUniqueBlockModelID(String a) {
		if (renderID == -1) {
			try {
				final TankRenderCubeStatic r = TankRenderCubeStatic.class.getConstructor().newInstance();
				renderID = RenderingRegistry.getNextAvailableRenderId();
				RenderingRegistry.registerBlockHandler(renderID, new ISimpleBlockRenderingHandler() {
					@Override
					public boolean shouldRender3DInInventory(int renderType) {
						return true;
					}

					@Override
					public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
						return r.renderWorldBlock(renderer, world, x, y, z, block, modelId);
					}

					@Override
					public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
						r.renderInvBlock(renderer, block, metadata, modelID);
					}

					@Override
					public int getRenderId() {
						return renderID;
					}
				});
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return renderID;
	}
	
	@EventHandler
    public void onPreLoad(FMLPreInitializationEvent aEvent) {
		Materials.preLoad();
		Recipes.initRecipes();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		NET = new NetworkHandler(MODID, "GTE",new IPacket[] {new FluidSync("",0," "), new FluidSync2(" ")});
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, proxy);
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
	public static String localize(String key) {
		return StatCollector.translateToLocal("gte." + key).replace("\\n", "\n").replace("@", "%").replace("\\%", "@");
		}
	public static String locTip(String key) {
		return StatCollector.translateToLocal("gte.tooltip." + key).replace("\\n", "\n").replace("@", "%").replace("\\%", "@");
		}
	
	
}
