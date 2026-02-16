package ato.nightmare;
import ato.nightmare.registers.ModRegister;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterThanNightmares implements ModInitializer {
	public static final String MOD_ID = "better-than-nightmares";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        ModRegister.initialize();
		LOGGER.info("Better Than Nightmares initialized");
	}
}