package dev.bar.cr;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import  dev.bar.cr.ListenerM;
import org.bukkit.inventory.Inventory;

import java.net.InetSocketAddress;

public class Cmds implements CommandExecutor {

    Main plugin;

    ListenerM listenerm = new ListenerM(plugin);

    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        Player Admin = (Player) s;  //second
        String arg1 = args[0];
        String arg2 = args[1];


        if(arg1.length()>0&&arg2.length()>0){

            if(Bukkit.getOnlinePlayers().equals(arg1)){
                //
                Player punished = Bukkit.getPlayer(arg1);
                punished.sendMessage("Command executed.");
                Location punLoc = Admin.getLocation();
                punished.teleport(punLoc);


                /*

                -GUI-

                 */
                Inventory gui = Bukkit.createInventory(Admin, 9, ChatColor.RED+"Punishing: "+punished.getDisplayName());
                listenerm.playerVals(punished,arg1);




            }

        }else{
            Admin.sendMessage("User not online.");

        }



        return false;
    }
}
