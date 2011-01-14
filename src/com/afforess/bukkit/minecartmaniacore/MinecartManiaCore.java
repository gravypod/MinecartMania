package com.afforess.bukkit.minecartmaniacore;
import java.io.File;
import java.util.logging.Logger;
import org.bukkit.Player;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecartManiaCore extends JavaPlugin {
	public MinecartManiaCore(PluginLoader pluginLoader, Server instance,
			PluginDescriptionFile desc, File plugin, ClassLoader cLoader) {
		super(pluginLoader, instance, desc, plugin, cLoader);
		server = instance;
		
	}

	public final MinecartManiaCoreListener listener = new MinecartManiaCoreListener(this);
	public final MinecartManiaActionListener actionListener = new MinecartManiaActionListener();
	public static Logger log;
	public static final String version = "0.3";
	public static final String buildType = "Alpha";
	public static Server server;
	
	

	public void onEnable(){
		log = Logger.getLogger("Minecraft");
		Configuration.loadConfiguration();
		 // Register our events
     //   pm.registerEvent(Event.Type.REDSTONE_CHANGE, listener, Priority.Normal, this);
     //   pm.registerEvent(Event.Type.VEHICLE_COLLISION_ENTITY, listener, Priority.Normal, this);
     //   pm.registerEvent(Event.Type.VEHICLE_CREATE, listener, Priority.Normal, this);
    //    pm.registerEvent(Event.Type.VEHICLE_DAMAGE, listener, Priority.Normal, this);
    //    pm.registerEvent(Event.Type.VEHICLE_ENTER, listener, Priority.Normal, this);
     //   pm.registerEvent(Event.Type.VEHICLE_EXIT, listener, Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Event.Type.VEHICLE_MOVE, listener, Priority.Highest, this);
        getServer().getPluginManager().registerEvent(Event.Type.CUSTOM_EVENT, actionListener, Priority.Highest, this);
     //   pm.registerEvent(Event.Type.PLAYER_COMMAND, listener, Priority.Normal, this);
     //   pm.registerEvent(Event.Type.BLOCK_PLACED, listener, Priority.Normal, this);
		//etc.getLoader().addListener(PluginLoader.Hook.VEHICLE_DESTROYED, listener, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener(PluginLoader.Hook.VEHICLE_UPDATE, listener, this, PluginListener.Priority.MEDIUM);
        //etc.getLoader().addListener(PluginLoader.Hook.OPEN_INVENTORY, listener, this, PluginListener.Priority.MEDIUM);
	//	etc.getLoader().addListener(PluginLoader.Hook.DISCONNECT, listener, this, PluginListener.Priority.MEDIUM);
        
        //getServer().getPluginManager().callEvent(arg0)

        PluginDescriptionFile pdfFile = this.getDescription();
        log.info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	}
	
	public void onDisable(){
		
	}
	
	public boolean isDebugging(final Player player) {
		return false;
    }

    public void setDebugging(final Player player, final boolean value) {
        
    }
}
