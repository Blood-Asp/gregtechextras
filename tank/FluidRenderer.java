package bloodasp.gregtechextras.tank;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import bloodasp.gregtechextras.tank.RenderEntityBlock.RenderInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public final class FluidRenderer {

	public static final int DISPLAY_STAGES = 100;
	private static final ResourceLocation BLOCK_TEXTURE = TextureMap.locationBlocksTexture;
	private static Map<Fluid, int[]> flowingRenderCache = new HashMap<Fluid, int[]>();
	private static Map<Fluid, int[]> stillRenderCache = new HashMap<Fluid, int[]>();
	private static final RenderInfo liquidBlock = new RenderInfo();

	/**
	 * Deactivate default constructor
	 */
	
	static {
		liquidBlock.textureArray = new IIcon[1];
		}
	private FluidRenderer() {

	}

	public static IIcon getFluidTexture(FluidStack fluidStack, boolean flowing) {
		if (fluidStack == null) {
			return null;
		}
		return getFluidTexture(fluidStack.getFluid(), flowing);
	}

	public static IIcon getFluidTexture(Fluid fluid, boolean flowing) {
		if (fluid == null) {
			return null;
		}
		IIcon icon = flowing ? fluid.getFlowingIcon() : fluid.getStillIcon();
		if (icon == null) {
			icon = ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
		}
		return icon;
	}

	public static ResourceLocation getFluidSheet(FluidStack liquid) {
		if (liquid == null) {
			return BLOCK_TEXTURE;
		}
		return getFluidSheet(liquid.getFluid());
	}

	public static ResourceLocation getFluidSheet(Fluid liquid) {
		return BLOCK_TEXTURE;
	}

	public static void setColorForFluidStack(FluidStack fluidstack) {
		if (fluidstack == null) {
			return;
		}

		int color = fluidstack.getFluid().getColor(fluidstack);
		RenderUtils.setGLColorFromInt(color);
	}

	public static int[] getLiquidDisplayLists(FluidStack fluidStack) {
		return getLiquidDisplayLists(fluidStack, false);
	}

	public static int[] getLiquidDisplayLists(FluidStack fluidStack, boolean flowing) {
		if (fluidStack == null)
			return null;
		Fluid fluid = fluidStack.getFluid();
		if (fluid == null)
			return null;
		Map<Fluid, int[]> cache = flowing ? flowingRenderCache : stillRenderCache;
		int[] diplayLists = cache.get(fluid);
		if (diplayLists != null)
			return diplayLists;
		diplayLists = new int[DISPLAY_STAGES];
		liquidBlock.textureArray[0] = null;
		if (fluid.getBlock() != null) {
			liquidBlock.template = fluid.getBlock();
			liquidBlock.textureArray[0] = getFluidTexture(fluidStack, flowing);
		} else {
			liquidBlock.template = Blocks.water;
			liquidBlock.textureArray[0] = getFluidTexture(fluidStack, flowing);
		}
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_CULL_FACE);
		for (int s = 0; s < DISPLAY_STAGES; ++s) {
			diplayLists[s] = GLAllocation.generateDisplayLists(1);
			GL11.glNewList(diplayLists[s], 4864 /* GL_COMPILE */);
			liquidBlock.minX = 0.01f;
			liquidBlock.minY = 0;
			liquidBlock.minZ = 0.01f;
			liquidBlock.maxX = 0.99f;
			liquidBlock.maxY = (float) s / (float) DISPLAY_STAGES;
			liquidBlock.maxZ = 0.99f;
			// RenderFakeBlock.renderBlockForEntity(liquidBlock, null, 0, 0, 0,
			// false, true);
			GL11.glEndList();
		}
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
		cache.put(fluid, diplayLists);
		return diplayLists;
	}
}