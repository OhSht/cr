package dev.bar.cr;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import  dev.bar.cr.ListenerM;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.net.InetSocketAddress;
import java.util.ArrayList;

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
                Inventory gui = Bukkit.createInventory(Admin, 27, ChatColor.RED+"Punishing: "+punished.getDisplayName());

                //all of the items in the GUI
                ItemStack RED = new ItemStack(Material.RED_BANNER);
                ItemStack BLUE = new ItemStack(Material.BLUE_BANNER);
                ItemStack GOLD = new ItemStack(Material.YELLOW_BANNER);
                ItemStack PURPLE = new ItemStack(Material.PURPLE_BANNER);
                ItemStack SPAWN = new ItemStack(Material.WHITE_BANNER);


                //setting all of the metas or descriptions of the items
                ItemMeta RED_meta = RED.getItemMeta();
                ItemMeta BLUE_meta = BLUE.getItemMeta();
                ItemMeta GOLD_meta = GOLD.getItemMeta();
                ItemMeta PURPLE_meta = PURPLE.getItemMeta();
                ItemMeta SPAWN_meta = SPAWN.getItemMeta();
                RED_meta.setDisplayName(ChatColor.RED + "BAN");
                SPAWN_meta.setDisplayName(ChatColor.RED + "Player info:\n"+ punished.getDisplayName());
                BLUE_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "BAN");
                GOLD_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "MUTE");
                PURPLE_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "PERMA-BAN");

                ArrayList<String> SPAWN_lore = new ArrayList<>();
                SPAWN_lore.add(ChatColor.GRAY + "SPECTATOR TEAM, YOU WILL NOT DIE.");
                SPAWN_meta.setLore(SPAWN_lore);//optional lore


                //sets the itemmeta i
                RED.setItemMeta(RED_meta);
                BLUE.setItemMeta(BLUE_meta);
                GOLD.setItemMeta(GOLD_meta);
                PURPLE.setItemMeta(PURPLE_meta);
                SPAWN.setItemMeta(SPAWN_meta);
                gui.setItem(11,RED);
                gui.setItem(13,GOLD);
                gui.setItem(15,PURPLE);


                listenerm.playerVals(punished,arg1);




            }

        }else{
            Admin.sendMessage("User not online.");

        }



        return false;
    }
}
