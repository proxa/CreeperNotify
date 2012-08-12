package org.hopto.seed419;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.hopto.seed419.file.Config;
import org.hopto.seed419.file.ConfigurationFile;
import org.hopto.seed419.listeners.CreeperPowerupListener;
import org.hopto.seed419.listeners.RadarJamListener;

public class CreeperNotify extends JavaPlugin {

    private CreeperPowerupListener cpl = new CreeperPowerupListener(this);
    private ConfigurationFile cf;

    public void onEnable() {
        cf = new ConfigurationFile(this);
        getServer().getPluginManager().registerEvents(cpl,this);
        if (getConfig().getBoolean(Config.radarJam)) {
            getServer().getPluginManager().registerEvents(new RadarJamListener(this), this);
        }
    }

    public boolean hasPerms(Player player) {
        return player.hasPermission("CreeperNotify.notify") || !getConfig().getBoolean(Config.usePerms);
    }
}