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
	private final int WIDTH = this.width;
	private final int HEIGHT = this.height;
	//private ResourceLocation guiImage;
	private Minecraft mc = Minecraft.getInstance();
	
	public TextGui() {
		super(new TranslationTextComponent("screen.guipunishkick.spawn"));

	}
	
	@Override
	protected void init() {
		super.init();
		//guiImage = new ResourceLocation("modid", "textures/gui/basicGUI.png");
		FontRenderer renderer = mc.fontRenderer;
		this.versionTextField = new TextFieldWidget(renderer, WIDTH / 2 + 150, HEIGHT / 2 + 100, 150, 20, null);
		this.confirmBtn = new Button(WIDTH / 2 + 175, HEIGHT / 2 + 150, 80, 20, new StringTextComponent("Confirm"), new IPressable() {
			
			@Override
			public void onPress(Button p_onPress_1_) {
				ClientEvents.versionText = versionTextField.getText();
				mc.currentScreen.closeScreen();	
			}
		});
		addButton(this.confirmBtn);
		versionTextField.setText(ClientEvents.versionText);
		versionTextField.setFocused2(true);
		versionTextField.setVisible(true);
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.setListener(this.versionTextField);
		this.versionTextField.render(matrixStack, mouseX, mouseY, partialTicks);
		this.confirmBtn.render(matrixStack, mouseX, mouseY, partialTicks);
		//renderBackground(matrixStack);
		//mc.getTextureManager().bindTexture(guiImage);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected <T extends Widget> T addButton(T button) {
		return super.addButton(button);
	}
}
