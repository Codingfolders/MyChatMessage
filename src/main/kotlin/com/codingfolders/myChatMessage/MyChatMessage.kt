package com.codingfolders.myChatMessage

import com.codingfolders.myChatMessage.events.PlayerChat
import com.codingfolders.myChatMessage.events.PlayerConnectionMessage

import org.bukkit.plugin.java.JavaPlugin

class MyChatMessage : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        saveDefaultConfig()

        var chatFormat: String? = null
        var joinMessageFormat: String? = null
        var quitMessageFormat: String? = null

        with (config) {
            chatFormat = getString("chat_format")
            joinMessageFormat = getString("connection_format.join")
            quitMessageFormat = getString("connection_format.quit")
        }

        server.pluginManager.registerEvents(PlayerConnectionMessage(joinMessageFormat, quitMessageFormat), this)
        server.pluginManager.registerEvents(PlayerChat(chatFormat), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
