package com.codingfolders.myChatMessage.events

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.entity.Player

class PlayerConnectionMessage(val joinMessageFormat: String?, val quitMessageFormat: String?) : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player: Player = event.player
        val message: Component = Component.text(
            joinMessageFormat?.replace("[player]", player.name).toString(),
            NamedTextColor.GREEN
        )

        event.joinMessage(message)
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        val player: Player = event.player
        val message: Component = Component.text(
            quitMessageFormat?.replace("[player]", player.name).toString(),
            NamedTextColor.RED
        )

        event.quitMessage(message)
    }
}
