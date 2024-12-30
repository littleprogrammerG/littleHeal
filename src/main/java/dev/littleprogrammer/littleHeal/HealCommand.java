package dev.littleprogrammer.littleHeal;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("litteHeal.heal") || sender.isOp()) {
            if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null && player.isOnline()) {
                    double maxHealth = player.getAttribute(Attribute.MAX_HEALTH).getValue();
                    player.setHealth(maxHealth);
                    player.spawnParticle(
                            Particle.HEART,
                            player.getLocation().getX(),
                            player.getLocation().getY(),
                            player.getLocation().getZ(),
                            1);
                    player.sendMessage(ChatColor.GREEN + "You have been healed by " + sender.getName() + "!");
                    sender.sendMessage(ChatColor.GREEN + "You have healed " + player.getName() + "!");
                } else {
                    sender.sendMessage(ChatColor.RED + args[0] + " doesn't exist or isn't online.");
                }
            } else if (sender instanceof Player player) {
                double maxHealth = player.getAttribute(Attribute.MAX_HEALTH).getValue();
                player.setHealth(maxHealth);
                player.spawnParticle(
                        Particle.HEART,
                        player.getLocation().getX(),
                        player.getLocation().getY(),
                        player.getLocation().getZ(),
                        1);
                player.sendMessage(ChatColor.GREEN + "You have been healed!");
            } else {
                sender.sendMessage(ChatColor.RED + "Please specify a player to heal!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        }

        return true;
    }
}
