package com.imabanana80.hidenametags;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import static org.bukkit.scoreboard.Team.Option.NAME_TAG_VISIBILITY;

public final class HideNametags extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
        Team hideNametags = board.getTeam("hideNametags");
        if (hideNametags == null){
            hideNametags = board.registerNewTeam("hideNametags");
            hideNametags.setOption(NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
        }

        hideNametags.addPlayer(p);
    }
}
