package forestry.factory.recipes.jei.rainmaker;

import javax.annotation.Nonnull;

import forestry.core.recipes.jei.ForestryRecipeCategory;
import forestry.core.recipes.jei.ForestryRecipeCategoryUid;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;

public class RainmakerRecipeCategory extends ForestryRecipeCategory<RainmakerRecipeWrapper> {
	private static final int SLOT_INPUT_INDEX = 0;
	private final IDrawable slot;

	public RainmakerRecipeCategory(@Nonnull IGuiHelper guiHelper) {
		super(guiHelper.createBlankDrawable(150, 30), "tile.for.rainmaker.name");
		this.slot = guiHelper.getSlotDrawable();
	}

	@Nonnull
	@Override
	public String getUid() {
		return ForestryRecipeCategoryUid.RAINMAKER;
	}

	@Override
	public void drawExtras(@Nonnull Minecraft minecraft) {
		super.drawExtras(minecraft);
		slot.draw(minecraft);
	}

	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull RainmakerRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(SLOT_INPUT_INDEX, true, 0, 0);
		guiItemStacks.set(ingredients);
	}
}
