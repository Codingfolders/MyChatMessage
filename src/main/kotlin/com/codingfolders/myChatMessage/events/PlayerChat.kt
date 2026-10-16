package com.codingfolders.myChatMessage.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.entity.Player

class PlayerChat (val chatFormat: String?) : Listener {
    @EventHandler
    fun onPlayerChat(event: PlayerChatEvent) {
        val player: Player = event.player
        val message: String = chatFormat?.replace(
            "[player]", player.name
        )?.replace(
            "[message]",
            event.message
        ).toString()

        event.format = message
    }
}