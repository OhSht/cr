package dev.bar.cr;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

public class ListenerM implements Listener{
    Main plugin;

    public ListenerM (Main instance){
        plugin = instance;

    }

    public void onJoin(PlayerJoinEvent e){
    }











    public  void playerVals(Player p, String args){

        File punished = new File("plugins/cr", "punished.yml");
        if (!punished.exists()) {
            try {
                punished.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileConfiguration pun = YamlConfiguration.loadConfiguration(punished);

        String name = p.getDisplayName();
        Location loc = p.getLocation();
        InetSocketAddress ip = p.getAddress();
        Integer bnd = 0;

        String UUID = String.valueOf(p.getUniqueId());

        if(!pun.contains(UUID)){

            pun.set(UUID+".User",name);
            pun.set(UUID+".ip",ip);
            pun.set(UUID+".#",bnd);

        }





    }



}
