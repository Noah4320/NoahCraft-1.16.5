package com.Noah4320.NoahCraft.client.render.screen;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class TextGui extends Screen{

	private TextFieldWidget TextField;
	private Button confirmBtn;
	private final int WIDTH = this.width;
	private final int HEIGHT = this.height;
	
	public TextGui() {
		super(new TranslationTextComponent("screen.guipunishkick.spawn"));
		// TODO Auto-generated constructor stub

	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		super.init();
		 FontRenderer renderer = Minecraft.getInstance().fontRenderer;
		this.TextField = new TextFieldWidget(renderer, WIDTH / 2 + 150, HEIGHT / 2 + 100, 150, 20, null);
		this.confirmBtn = new Button(WIDTH / 2 + 175, HEIGHT / 2 + 150, 80, 20, new StringTextComponent("Confirm"), new IPressable() {
			
			@Override
			public void onPress(Button p_onPress_1_) {
				// TODO Auto-generated method stub
				System.out.println("button pressed!");
			}
		});
		TextField.setText("");
		TextField.setFocused2(true);
		TextField.setVisible(true);
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.setListener(this.TextField);
		this.TextField.render(matrixStack, mouseX, mouseY, partialTicks);
		this.confirmBtn.render(matrixStack, mouseX, mouseY, partialTicks);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
}
