package bloodasp.gregtechextras.tank;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import gregapi.old.GregTech_API;
import gregapi.old.Textures;
import gregapi.render.ITexture;
import gregapi.old.interfaces.metatileentity.IMetaTileEntity;
import gregapi.old.interfaces.tileentity.IGregTechTileEntity;
//import gregapi.old.metatileentity.implementations.GT_MetaTileEntity_Hatch_Input;
//import gregapi.old.metatileentity.implementations.GT_MetaTileEntity_Hatch_Output;
//import gregapi.old.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregapi.recipes.GT_ModHandler;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class GTE_Multi_Tank{// extends //GT_MetaTileEntity_MultiBlockBase {
	int tank;
	FluidStack mFluid;
	int width;
	int depth;
	int height;
	int blockCap;
	volatile Block casing = Blocks.planks;
	volatile int casingTexture = 48;
	volatile byte casingMeta = 10;

	public GTE_Multi_Tank(int aID, String aName, String aNameRegional) {
		//super(aID, aName, aNameRegional);
		tank = 1000;
		width = 1;
		depth = 1;
		height = 1;
		blockCap = 4;
	}

	public GTE_Multi_Tank(String aName) {
		//super(aName);
	}

	//@Override
	public String[] getDescription() {
		return new String[] { "Controller Block for Multiblocktanks", "Size: 3x3x5", "Controller (front bottom)", "Edges from Casings(27)", "Sides with Fluid Hatches or Glass" };
	}

	public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {

		if (aSide == aFacing) {
			return new ITexture[] { Textures.BlockIcons.CASING_BLOCKS[casingTexture]
					//,new GT_RenderedTexture(aActive ? Textures.BlockIcons.OVERLAY_FRONT_LARGE_BOILER_ACTIVE : Textures.BlockIcons.OVERLAY_FRONT_LARGE_BOILER) 
			};
		}
		// System.out.println("CasingTexture: "+casingTexture);
		return new ITexture[] { Textures.BlockIcons.CASING_BLOCKS[casingTexture] };
	}

	//@Override
	public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
		return null;// new GTE_Multi_Tank(this.mName);
	}

	//@Override
	public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
		System.out.println("start check");
		boolean controller = false;
		int xDir = ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetX;
		int zDir = ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetZ;

		// Check size
		Block tmp = aBaseMetaTileEntity.getBlockOffset(zDir, 0, xDir);
		// System.out.println(tmp.getUnlocalizedName() + " " + xDir + " " +
		// zDir);
//		if (tmp == GregTech_API.sBlockCasings4) {// Tungstensteel
//			if (aBaseMetaTileEntity.getMetaIDOffset(zDir, 0, xDir) == 0) {
//				casing = GregTech_API.sBlockCasings4;
//				casingMeta = 0;
//				casingTexture = 48;
//				System.out.println("Tungstensteel");
//			} else if (aBaseMetaTileEntity.getMetaIDOffset(zDir, 0, xDir) == 2) {// Titanium
//				casing = GregTech_API.sBlockCasings4;
//				casingMeta = 2;
//				casingTexture = 50;
//			} else if (aBaseMetaTileEntity.getMetaIDOffset(zDir, 0, xDir) == 2) {// Stainless
//																					// Steel
//				casing = GregTech_API.sBlockCasings4;
//				casingMeta = 1;
//				casingTexture = 49;
//			}
//		} else if (tmp == GregTech_API.sBlockCasings2) {// Steel
//			if (aBaseMetaTileEntity.getMetaIDOffset(zDir, 0, xDir) == 0) {
//				casing = GregTech_API.sBlockCasings2;
//				casingMeta = 0;
//				casingTexture = 16;
//			}
//		} else if (tmp == GregTech_API.sBlockCasings1) {// Bronze
//			if (aBaseMetaTileEntity.getMetaIDOffset(zDir, 0, xDir) == 10) {
//				casing = GregTech_API.sBlockCasings1;
//				casingMeta = 10;
//				casingTexture = 10;
//			}
//		} else if (tmp == Blocks.planks) {// Wood
//			casing = Blocks.planks;
//			casingMeta = 0;
//			casingTexture = 10;
//		}

		for (int i = 1; i < 9; i++) {
			System.out.println("i " + i);
			if (aBaseMetaTileEntity.getBlockOffset(xDir * i, 1, zDir * i) != Blocks.air && i > 1) {
				for (int f = 2; f < 9; f++) {
					System.out.println("f " + f);
					if (aBaseMetaTileEntity.getBlockOffset(xDir * (i - 1), f, zDir * (i - 1)) != Blocks.air) {
						for (int g = 1; g < 5; g++) {
							System.out.println("g " + g);
							if (xDir == 0) {
								System.out.println("xDir: " + xDir);
								if (aBaseMetaTileEntity.getBlockOffset(g, f - 1, zDir * (i - 1)) != Blocks.air) {
									width = g * 2 + 1;
									depth = i + 1;
									height = f + 1;
									i = 10;
									f = 10;
									g = 10;
								}
							} else {
								if (aBaseMetaTileEntity.getBlockOffset(xDir * (i - 1), f - 1, g) != Blocks.air) {
									width = i + 1;
									depth = g * 2 + 1;
									height = f + 1;
									i = 10;
									f = 10;
									g = 10;
								}
							}
						}
					}
				}

			}
		}
		System.out.println("width: " + width + " depth; " + depth + " height: " + height);

		System.out.println(casing.getUnlocalizedName() + " " + casingMeta + " " + casingTexture);

		// Check edges
		System.out.println("Check edges");
		xDir = xDir * (depth / 2);
		zDir = zDir * (depth / 2);
		int s, t;
		if (xDir == 0) {
			s = depth / 2;
			t = width / 2;
		} else {
			t = depth / 2;
			s = width / 2;
		}
		int sn=0-s;
		int tn=0-t;
		System.out.println("dirnew: " + xDir + " " + zDir +" s "+s+" t "+t+" sn "+sn+" tn "+tn);
		for (int i = sn; i < s+1; i++) {
			System.out.println("i "+i);
			for (int j = tn; j < t+1; j++) {
				System.out.println("ij "+i+" "+j);
				if (i == sn || i == s || j == tn || j == t) {
					System.out.println(aBaseMetaTileEntity.getBlockOffset(xDir + i, 0, zDir + j));
					if (aBaseMetaTileEntity.getBlockOffset(xDir + i, 0, zDir + j) != getCasingBlock()) {
						if (!controller && aBaseMetaTileEntity.getBlockOffset(xDir + i, 0, zDir + j) == GregTech_API.sBlockMachines) {
							controller = true;
						} else {
							System.out.println("Block fail: "+aBaseMetaTileEntity.getBlockOffset(xDir + i, 0, zDir + j));
							return false;
						}
					}
//					System.out.println(aBaseMetaTileEntity.getMetaIDOffset(xDir + i, 0, zDir + j));
//					if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, 0, zDir + j) != getCasingMeta()) {
//						System.out.println("Meta Fail "+aBaseMetaTileEntity.getMetaIDOffset(xDir + i, 0, zDir + j));
//						if(casing != Blocks.planks&&aBaseMetaTileEntity.getBlockOffset(xDir + i, 0, zDir + j) != GregTech_API.sBlockMachines){
//						return false;}
//					}
//
//					if (aBaseMetaTileEntity.getBlockOffset(xDir + i, height-1, zDir + j) != getCasingBlock()) {
//						System.out.println("block2");
//						return false;
//					}
//					if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, height-1, zDir + j) != getCasingMeta()) {
//						System.out.println("Meta2");
//						if(casing != Blocks.planks){
//							return false;}
//					}
				} else {
					if (!checkSide(aBaseMetaTileEntity, xDir + i, 0, zDir + j)) {
						System.out.println("meta1");
						return false;
					}
					if (!checkSide(aBaseMetaTileEntity, xDir + i, height - 1, zDir + j)) {
						System.out.println("meta2");
						return false;
					}
				}
			}
		}
		// Check sides
		System.out.println("check sides");
		for (int i = sn; i < s+1; i++) {
			for (int j = tn; j < t+1; j++) {
				for (int k = 1; k < height-1; k++) {
					if ((i == sn && j == tn) || (i == sn && j == t) || (i == s && j == tn) || (i == s && j == t)) {
						if (aBaseMetaTileEntity.getBlockOffset(xDir + i, height-1, zDir + j) != getCasingBlock()) {
							return false;
						}
//						if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, height-1, zDir + j) != getCasingMeta()) {
//							if(casing != Blocks.planks){
//								return false;}
//						}
					} else {
						if (i == 0 && j == 0) {
							if (!aBaseMetaTileEntity.getAirOffset(xDir, k, zDir)) {
								if (!(aBaseMetaTileEntity.getBlockOffset(xDir, k, zDir) instanceof BlockTank)) {
									return false;
								}
							}
						} else {
							if (!checkSide(aBaseMetaTileEntity, xDir + i, k, zDir + j)) {
								return false;
							}
						}

					}
				}
			}
		}

		switch (casingTexture) {
		case 50:
			blockCap = 40;// Titanium
			break;
		case 49:
			blockCap = 32;// Stainless Steel
			break;
		case 48:
			blockCap = 48;// Tungstensteel
			break;
		case 16:
			blockCap = 24;// Steel
			break;
		case 10:
			blockCap = casingMeta == 0 ? 4 : 16;// Wood/Bronze
			break;
		default:
			blockCap = 4;
		}
		tank = width * depth * height * blockCap * 1000;

		System.out.println("check done");
//		this.mEUt = 10000000;
//		this.mWrench = true;
//		this.mScrewdriver = true;
//		this.mSoftHammer = true;
//		this.mHardHammer = true;
//		this.mSolderingTool = true;
//		this.mCrowbar = true;
		System.out.println("Check done: " + casing.getUnlocalizedName() + " " + casingTexture + " " + casingMeta);
		return true;
	}

	private boolean checkSide(IGregTechTileEntity aBaseMetaTileEntity, int x, int y, int z) {
		if (aBaseMetaTileEntity.getBlockOffset(x, y, z) == Blocks.glass) {
			return true;
		} else {
//			IGregTechTileEntity tTileEntity = aBaseMetaTileEntity.getIGregTechTileEntityOffset(x, y, z);
//			if ((!addInputToMachineList(tTileEntity, casingTexture)) && (!addOutputToMachineList(tTileEntity, casingTexture))) {
//				if (aBaseMetaTileEntity.getBlockOffset(x, y, z) != casing) {
//					return false;
//				}
//				if (aBaseMetaTileEntity.getMetaIDOffset(x, y, z) != casingMeta) {
//					if(casing != Blocks.planks){
//						return false;}
//				}
//			}
		}
		return true;
	}

	private byte getCasingMeta() {
		return casingMeta;
	}

	private int getCasingTextureIndex() {
		return casingTexture;
	}

	private Block getCasingBlock() {
		return casing;
	}

//	@Override
//	public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
//		if (aBaseMetaTileEntity.isServerSide()) {
//			if (--mUpdate == 0 || --mStartUpCheck == 0) {
//				mMachine = checkMachine(aBaseMetaTileEntity, mInventory[1]);
//			}
//			if (mMachine) {
//				for (GT_MetaTileEntity_Hatch_Input tHatch : this.mInputHatches) {
//					if (isValidMetaTileEntity(tHatch)) {
//						FluidStack tLiquid = tHatch.getFluid();
//						if (tLiquid != null) {
//							if (mFluid != null) {
//								if (tLiquid.fluidID == mFluid.fluidID) {
//									int drainAmount = tank - mFluid.amount;
//									if (drainAmount > 100) {
//										drainAmount = 100;
//									}
//									tLiquid = tHatch.drain(drainAmount, false);
//									if ((tLiquid != null) && (tLiquid.amount > 0)) {
//										tLiquid = tHatch.drain(tLiquid.amount, true);
//										mFluid.amount += tLiquid.amount;
//										if (tLiquid.amount > 0) {
//											getBaseMetaTileEntity().markDirty();
//										}
//									}
//								}
//							} else {
//								mFluid = tHatch.drain(100, true);
//								testTemp(mFluid.getFluid().getTemperature());
//								getBaseMetaTileEntity().markDirty();
//							}
//						}
//					}
//				}
//				if (mFluid != null) {
//					if (mFluid.amount > 0) {
//						for (GT_MetaTileEntity_Hatch_Output tHatch : this.mOutputHatches) {
//							if (isValidMetaTileEntity(tHatch)) {
//								int tmp = tHatch.fill(mFluid, true);
//								mFluid.amount = mFluid.amount - tmp;
//								if (tmp > 0) {
//									getBaseMetaTileEntity().markDirty();
//								}
//							}
//						}
//					} else {
//						mFluid = null;
//					}
//				}
//			}
//		}
//	}

	private void testTemp(int temperature) {
		switch (casingTexture) {
//		case 50:
//			if(temperature>5000){explodeMultiblock();}// Titanium
//			break;
//		case 49:
//			if(temperature>3000){explodeMultiblock();}// Stainless Steel
//			break;
//		case 48:
//			if(temperature>12500){explodeMultiblock();}// Tungstensteel
//			break;
//		case 16:
//			if(temperature>2500){explodeMultiblock();}// Steel
//			break;
//		case 10:
//			testTemp2(temperature);// Wood/Bronze
//			break;
		default:
		}
	}

	private void testTemp2(int temperature) {
//		if(casingMeta==0&&temperature>350){
//			explodeMultiblock();
//		}else if(casingMeta==4&&temperature>2000){
//			explodeMultiblock();
//		}
	}

//	@Override
//	public boolean checkRecipe(ItemStack arg0) {
//		return true;
//	}
//
//	@Override
//	public boolean explodesOnComponentBreak(ItemStack arg0) {
//		return false;
//	}
//
//	@Override
//	public int getAmountOfOutputs() {
//		return 1;
//	}
//
//	@Override
//	public int getDamageToComponent(ItemStack arg0) {
//		return 0;
//	}
//
//	@Override
//	public int getMaxEfficiency(ItemStack arg0) {
//		return 10000;
//	}
//
//	@Override
//	public int getPollutionPerTick(ItemStack arg0) {
//		return 0;
//	}
//
//	@Override
//	public boolean isCorrectMachinePart(ItemStack arg0) {
//		return true;
//	}
//
//	@Override
//	public FluidStack getFluid() {
//		return mFluid;
//	}
//
//	@Override
//	public int fill(FluidStack resource, boolean doFill) {
//		return 0;
//	}
//
//	@Override
//	public FluidStack drain(int maxDrain, boolean doDrain) {
//		return null;
//	}
//
//	public int getTankPressure() {
//		return -100;
//	}
//
//	@Override
//	public int getCapacity() {
//		return tank;
//	}
//
//	@Override
//	public void saveNBTData(NBTTagCompound aNBT) {
//		super.saveNBTData(aNBT);
//		if (mFluid != null)
//			aNBT.setTag("mFluid", mFluid.writeToNBT(new NBTTagCompound()));
//	}
//
//	@Override
//	public void loadNBTData(NBTTagCompound aNBT) {
//		super.loadNBTData(aNBT);
//		mFluid = FluidStack.loadFluidStackFromNBT(aNBT.getCompoundTag("mFluid"));
//	}
//
//	@Override
//	public String[] getInfoData() {
//		return new String[] { "Tank enabled" };
//	}

}
