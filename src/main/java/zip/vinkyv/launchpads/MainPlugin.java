package zip.vinkyv.launchpads;

import java.util.List;

import cn.nukkit.plugin.PluginBase;

public class MainPlugin extends PluginBase {
    public static List<Integer> blocks;   //Set blocks list
    public static List<Integer> multiple; //Set multiple list

    @Override
    public void onEnable() {
        this.saveDefaultConfig();                                          //Save DefaultConfig if doesnt exists
        blocks = this.getConfig().getIntegerList("launchpads.blocks");     // Load blocks list
        multiple = this.getConfig().getIntegerList("launchpads.multiple"); // Load multiple list
        this.getLogger().info("======= [ Launchpads ] =======");
        this.getLogger().info("Blocks: " + blocks.toString());             // Print loaded blocks
        this.getLogger().info("Multipliers: " + multiple.toString());      // Print loaded multipliers
        this.getLogger().info("==============================");
        if (blocks.size() == multiple.size()) {                            // Checking if config is correct
            this.getLogger().info("Launchpads loaded!");
        } else {
            this.getLogger().error("Error loading launchpads!");
            this.getPluginLoader().disablePlugin(null); // Unload plugin if config is uncorrect
        }
        this.getServer().getPluginManager().registerEvents(new EventListener(), this); // Register EventListener
        this.getLogger().info("Loaded succesfully!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Unloaded succesfully!");
    }
}