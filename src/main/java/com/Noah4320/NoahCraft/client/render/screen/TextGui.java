package com.Noah4320.NoahCraft.client.render.screen;

import com.Noah4320.NoahCraft.NoahCraft;
import com.Noah4320.NoahCraft.client.event.ClientEvents;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
public class TextGui extends Screen{

	private TextFieldWidget versionTextField;
	private Button confirmBtn;
	private ResourceLocation guiImage = new ResourceLocation(NoahCraft.MOD_ID, "textures/gui/basic_gui.png");
	private Minecraft mc = Minecraft.getInstance();
	
	public TextGui() {
		super(new TranslationTextComponent("screen.guipunishkick.spawn"));

	}
	
	@Override
	protected void init() {
		super.init();
		FontRenderer renderer = mc.fontRenderer;
		versionTextField = new TextFieldWidget(renderer, 150, 100, 150, 20, new StringTextComponent("Test"));
		confirmBtn = new Button(180, 145, 80, 20, new StringTextComponent("Confirm"), new IPressable() {
			
			@Override
			public void onPress(Button p_onPress_1_) {
				ClientEvents.versionText = versionTextField.getText();
				mc.currentScreen.closeScreen();	
			}
		});
		addButton(confirmBtn);
		addButton(versionTextField);
		versionTextField.setText(ClientEvents.versionText);
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {

		versionTextField.render(matrixStack, mouseX, mouseY, partialTicks);
		confirmBtn.render(matrixStack, mouseX, mouseY, partialTicks);
		renderBackground(matrixStack);
		mc.getTextureManager().bindTexture(guiImage);
		this.blit(matrixStack, 137, 90, 0, 0, 256, 256);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
	
	
	@Override
	protected <T extends Widget> T addButton(T button) {
		return super.addButton(button);
	}
}
