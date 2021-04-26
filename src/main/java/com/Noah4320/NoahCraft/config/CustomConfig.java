package com.Noah4320.NoahCraft.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.Noah4320.NoahCraft.NoahCraft;
import com.Noah4320.NoahCraft.client.event.ClientEvents;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod.EventBusSubscriber
public class CustomConfig {

	private static String path = FMLPaths.GAMEDIR.get().resolve(FMLConfig.defaultConfigPath()).toString();
	private static String name = "Noahcraft.txt";
	private static String absolutePath = path + File.separatorChar + name;
	
	
	public CustomConfig() {
		read();
		
	}
	
	public static void write(String version) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(absolutePath));
			writer.write(version);
			writer.close();
		} catch (IOException e) {
			NoahCraft.LOGGER.info("Unexpected config writing error");
		}
	}
	
	
	public static String read() {
		NoahCraft.LOGGER.info("Reading config..");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
			String line = reader.readLine();
			ClientEvents.versionText = line;
			reader.close();
			return line;
		} catch (FileNotFoundException e) {
			NoahCraft.LOGGER.info("No config file found. Creating file at: " + absolutePath);
			File file = new File(absolutePath);
			try {
				file.createNewFile();
				NoahCraft.LOGGER.info("Config file created!");
			} catch (IOException e1) {
				NoahCraft.LOGGER.info("Unexpected config file creation error");
				e1.printStackTrace();
			}
		} catch (IOException e) {
			NoahCraft.LOGGER.info("Unexpected config reading error");
		}
	
	return "";
	}
	
	
}
