package com.Noah4320.NoahCraft.client.render.screen;

import com.Noah4320.NoahCraft.client.event.ClientEvents;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

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
	//private ResourceLocation guiImage = new ResourceLocation("textures/gui/basic_gui.png");
	private Minecraft mc = Minecraft.getInstance();
	//private int xSize = 256;
	//private int ySize = 256;
	
	public TextGui() {
		super(new TranslationTextComponent("screen.guipunishkick.spawn"));

	}
	
	@Override
	protected void init() {
		super.init();
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

	@SuppressWarnings("deprecation")
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		//RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.setListener(this.versionTextField);
		this.versionTextField.render(matrixStack, mouseX, mouseY, partialTicks);
		this.confirmBtn.render(matrixStack, mouseX, mouseY, partialTicks);
		//renderBackground(matrixStack);
		//mc.getTextureManager().bindTexture(guiImage);
		 //int edgeSpacingX = (this.width - this.xSize) / 2;
		    //int edgeSpacingY = (this.height - this.ySize) / 2;
		    //this.blit(matrixStack, edgeSpacingX, edgeSpacingY, 0, 0, this.xSize, this.ySize);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
	
	
	@Override
	protected <T extends Widget> T addButton(T button) {
		return super.addButton(button);
	}
}
