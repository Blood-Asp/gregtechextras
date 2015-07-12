package bloodasp.gregtechextras.tank;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

@SideOnly(Side.CLIENT)
public class TankHalo extends TileEntity {
	private static TankHalo instance = new TankHalo();
	private TankHalo() {}
	
	static {
		MinecraftForge.EVENT_BUS.register(instance);
	}
	
	private static class XYZ {
		public final int x, y, z;
		public XYZ(int x, int y, int z) {this.x=x;this.y=y;this.z=z;}
		
		private static int[] randomTable;
		static {
			randomTable = new int[256];
			Random r = new Random();
			for(int k = 0; k < randomTable.length; k++)
				randomTable[k] = r.nextInt();
		}
		
		@Override
		public int hashCode() {
			return randomTable[x&255] ^ randomTable[y&255] ^ randomTable[z&255];
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof XYZ) {
				XYZ a = (XYZ)o;
				return x == a.x && y == a.y && z == a.z;
			}
			return false;
		}
	}
	
	//private static WeakReference<IBlockAccess> lastSeenWorld = new WeakReference<IBlockAccess>(null);
	private static Set<XYZ> lamps = new HashSet<XYZ>();
	
	static void addLamp(IBlockAccess w, int x, int y, int z) {
		/*if(w != lastSeenWorld.get()) {
			lastSeenWorld = new WeakReference<IBlockAccess>((IBlockAccess)w);
			lamps.clear();
		}*/
		XYZ tmp = new XYZ(x,y,z);
		if(!lamps.contains(tmp)){
		lamps.add(new XYZ(x, y, z));}
	}
	
	
	@SubscribeEvent
	public void onRenderWorldLast(RenderWorldLastEvent evt) {
		WorldClient w = Minecraft.getMinecraft().theWorld;
		
		List<XYZ> toRemove = null;
		
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE); // additive blending
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glPushMatrix();
		GL11.glDepthMask(false);

		//GTExtras.tank.bindTexture(FluidRenderer.getFluidSheet(FluidRegistry.WATER));
		//Minecraft.getMinecraft().renderEngine.bindTexture(FluidRenderer.getFluidSheet(FluidRegistry.WATER));
		Tessellator t = Tessellator.instance;
		
		
		EntityLivingBase view = Minecraft.getMinecraft().renderViewEntity;
		if(view != null) {
			double pt = evt.partialTicks;
			double x = view.prevPosX + (view.posX - view.prevPosX) * pt;
			double y = view.prevPosY + (view.posY - view.prevPosY) * pt;
			double z = view.prevPosZ + (view.posZ - view.prevPosZ) * pt;
			GL11.glTranslated(-x, -y, -z);
		}
		
		
		t.startDrawingQuads();
		for(XYZ pos : lamps) {
			Block block = w.getBlock(pos.x, pos.y, pos.z);
			
			if(block instanceof BlockTank ) {
				int colour = w.getBlockMetadata(pos.x, pos.y, pos.z);
				
				renderHalo(t, pos.x, pos.y, pos.z, colour);
				
//				GL11.glPushMatrix();
//				GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
//				GL11.glEnable(GL11.GL_CULL_FACE);
//				GL11.glDisable(GL11.GL_LIGHTING);
//				GL11.glEnable(GL11.GL_BLEND);
//				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				
//				int[] displayLists = FluidRenderer.getLiquidDisplayLists(new FluidStack(FluidRegistry.WATER,7500));
//				if (displayLists != null) {
//				GL11.glPushMatrix();
//				float cap = 10000;
//				float level = (float) Math.min(7500, cap) / cap;
//				Minecraft.getMinecraft().renderEngine.bindTexture(FluidRenderer.getFluidSheet(FluidRegistry.WATER));
//				FluidRenderer.setColorForTank(tank);
//				GL11.glCallList(displayLists[(int) (level * (float) (FluidRenderer.DISPLAY_STAGES - 1))]);
//				GL11.glPopMatrix();
				
				
				
				} else {
				if(toRemove == null)
					toRemove = new ArrayList<XYZ>();
				toRemove.add(pos);
			}
			
			
		}
		t.draw();
		
		if(toRemove != null)
			for(XYZ pos : toRemove){
				lamps.remove(pos);
				System.out.println("REmove lamps!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
		
//		GL11.glPopAttrib();
//		GL11.glPopMatrix();
//		}
//		// reset GL state
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(1, 1, 1);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glDepthMask(true);
	}
	
	static final double HALO_SIZE = 0.9f;
	private static final double BB_MIN = 0 - HALO_SIZE;
	private static final double BB_MAX = 1 + HALO_SIZE;

	private static final int ALPHA = 128;
	
	static void renderHalo(Tessellator t, double x, double y, double z, int colourNumber) {
		renderHalo(t, colourNumber, x+BB_MIN, x+BB_MAX, y+BB_MIN, y+(BB_MAX*2), z+BB_MIN, z+BB_MAX);
	}
	
	static void renderHalo(Tessellator t, double x, double y, double z, int colourNumber, AxisAlignedBB bb) {
		renderHalo(t, colourNumber,
			x+bb.minX, x+bb.maxX,
			y+bb.minY, y+bb.maxY,
			z+bb.minZ, z+bb.maxZ);
	}
	
	static void renderHalo(Tessellator t, int colourNumber, double x1, double x2, double y1, double y2, double z1, double z2) {
		int colour = FluidRegistry.WATER.getDensity();
		colour = 0x0000FF;
		
		//t.setColorRGBA_I(colour, ALPHA);
		t.setColorRGBA_I(colour, FluidRegistry.WATER.getDensity());
		//GL11.glColor3b((byte)(colour >> 16), (byte)(colour >> 8), (byte)colour);
		
		t.addVertex(x1, y2, z1);
		t.addVertex(x2, y2, z1);
		t.addVertex(x2, y1, z1);
		t.addVertex(x1, y1, z1);
		
		t.addVertex(x1, y1, z1);
		t.addVertex(x1, y1, z2);
		t.addVertex(x1, y2, z2);
		t.addVertex(x1, y2, z1);
		
		t.addVertex(x1, y1, z1);
		t.addVertex(x2, y1, z1);
		t.addVertex(x2, y1, z2);
		t.addVertex(x1, y1, z2);
		
		t.addVertex(x1, y1, z2);
		t.addVertex(x2, y1, z2);
		t.addVertex(x2, y2, z2);
		t.addVertex(x1, y2, z2);
		
		t.addVertex(x2, y2, z1);
		t.addVertex(x2, y2, z2);
		t.addVertex(x2, y1, z2);
		t.addVertex(x2, y1, z1);
		
		t.addVertex(x1, y2, z2);
		t.addVertex(x2, y2, z2);
		t.addVertex(x2, y2, z1);
		t.addVertex(x1, y2, z1);
	}
}
