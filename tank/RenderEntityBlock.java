package bloodasp.gregtechextras.tank;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public final class RenderEntityBlock extends Render {

	public static RenderEntityBlock INSTANCE = new RenderEntityBlock();
	protected RenderBlocks renderBlocks;

	private RenderEntityBlock() {
		renderBlocks = field_147909_c;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public static class RenderInfo {

		public double minX;
		public double minY;
		public double minZ;
		public double maxX;
		public double maxY;
		public double maxZ;
		public Block baseBlock = Blocks.sand;
		public IIcon texture = null;
		public IIcon[] textureArray = null;
		public boolean[] renderSide = new boolean[6];
		public float light = -1f;
		public int brightness = -1;
		public Block template;

		public RenderInfo() {
			setRenderAllSides();
		}

		public RenderInfo(Block template, IIcon[] texture) {
			this();
			this.baseBlock = template;
			this.textureArray = texture;
		}

		public RenderInfo(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
			this();
			setBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}

		public float getBlockBrightness(IBlockAccess iblockaccess, int i, int j, int k) {
			return baseBlock.getMixedBrightnessForBlock(iblockaccess, i, j, k);
		}

		public final void setBounds(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
			this.minX = minX;
			this.minY = minY;
			this.minZ = minZ;
			this.maxX = maxX;
			this.maxY = maxY;
			this.maxZ = maxZ;
		}

		public final void setRenderSingleSide(int side) {
			Arrays.fill(renderSide, false);
			renderSide[side] = true;
		}

		public final void setRenderAllSides() {
			Arrays.fill(renderSide, true);
		}

		public void rotate() {
			double temp = minX;
			minX = minZ;
			minZ = temp;

			temp = maxX;
			maxX = maxZ;
			maxZ = temp;
		}

		public void reverseX() {
			double temp = minX;
			minX = 1 - maxX;
			maxX = 1 - temp;
		}

		public void reverseZ() {
			double temp = minZ;
			minZ = 1 - maxZ;
			maxZ = 1 - temp;
		}

		public IIcon getBlockTextureFromSide(int i) {
			if (texture != null) {
				return texture;
			}

			int index = i;

			if (textureArray == null || textureArray.length == 0) {
				return baseBlock.getBlockTextureFromSide(index);
			} else {
				if (index >= textureArray.length) {
					index = 0;
				}

				return textureArray[index];
			}
		}
	}


	public void renderBlock(RenderInfo info, IBlockAccess blockAccess, int x, int y, int z, boolean doLight, boolean doTessellating) {
		renderBlock(info, blockAccess, x, y, z, x, y, z, doLight, doTessellating);
	}

	public void renderBlock(RenderInfo info, IBlockAccess blockAccess, double x, double y, double z, int lightX, int lightY, int lightZ, boolean doLight, boolean doTessellating) {
		float lightBottom = 0.5F;
		float lightTop = 1.0F;
		float lightEastWest = 0.8F;
		float lightNorthSouth = 0.6F;

		Tessellator tessellator = Tessellator.instance;

		boolean realDoLight = doLight;

		if (blockAccess == null) {
			realDoLight = false;
		}

		if (doTessellating) {
			tessellator.startDrawingQuads();
		}

		float light = 0;
		if (realDoLight) {
			if (info.light < 0) {
				light = info.baseBlock.getMixedBrightnessForBlock(blockAccess, lightX, lightY, lightZ);
				light = light + ((1.0f - light) * 0.4f);
			} else {
				light = info.light;
			}
			int brightness = 0;
			if (info.brightness < 0) {
				brightness = info.baseBlock.getMixedBrightnessForBlock(blockAccess, lightX, lightY, lightZ);
			} else {
				brightness = info.brightness;
			}
			tessellator.setBrightness(brightness);
			tessellator.setColorOpaque_F(lightBottom * light, lightBottom * light, lightBottom * light);
		} else {
//			tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
			if (info.brightness >= 0) {
				tessellator.setBrightness(info.brightness);
			}
		}

		renderBlocks.setRenderBounds(info.minX, info.minY, info.minZ, info.maxX, info.maxY, info.maxZ);

		if (info.renderSide[0]) {
			renderBlocks.renderFaceYNeg(info.baseBlock, x, y, z, info.getBlockTextureFromSide(0));
		}

		if (realDoLight) {
			tessellator.setColorOpaque_F(lightTop * light, lightTop * light, lightTop * light);
		}

		if (info.renderSide[1]) {
			renderBlocks.renderFaceYPos(info.baseBlock, x, y, z, info.getBlockTextureFromSide(1));
		}

		if (realDoLight) {
			tessellator.setColorOpaque_F(lightEastWest * light, lightEastWest * light, lightEastWest * light);
		}

		if (info.renderSide[2]) {
			renderBlocks.renderFaceZNeg(info.baseBlock, x, y, z, info.getBlockTextureFromSide(2));
		}

		if (realDoLight) {
			tessellator.setColorOpaque_F(lightEastWest * light, lightEastWest * light, lightEastWest * light);
		}

		if (info.renderSide[3]) {
			renderBlocks.renderFaceZPos(info.baseBlock, x, y, z, info.getBlockTextureFromSide(3));
		}

		if (realDoLight) {
			tessellator.setColorOpaque_F(lightNorthSouth * light, lightNorthSouth * light, lightNorthSouth * light);
		}

		if (info.renderSide[4]) {
			renderBlocks.renderFaceXNeg(info.baseBlock, x, y, z, info.getBlockTextureFromSide(4));
		}

		if (realDoLight) {
			tessellator.setColorOpaque_F(lightNorthSouth * light, lightNorthSouth * light, lightNorthSouth * light);
		}

		if (info.renderSide[5]) {
			renderBlocks.renderFaceXPos(info.baseBlock, x, y, z, info.getBlockTextureFromSide(5));
		}

		if (doTessellating) {
			tessellator.draw();
		}
	}

	@Override
	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
		// TODO Auto-generated method stub
		
	}
}
