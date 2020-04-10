package com.yourname.projectname

import br.com.devsrsouza.kotlinbukkitapi.architecture.KotlinPlugin
import br.com.devsrsouza.kotlinbukkitapi.dsl.command.arguments.player
import br.com.devsrsouza.kotlinbukkitapi.dsl.command.command
import br.com.devsrsouza.kotlinbukkitapi.dsl.command.sendSubCommandsList
import br.com.devsrsouza.kotlinbukkitapi.dsl.command.simpleCommand
import br.com.devsrsouza.kotlinbukkitapi.extensions.text.msg
import br.com.devsrsouza.kotlinbukkitapi.extensions.text.plus
import br.com.devsrsouza.kotlinbukkitapi.extensions.text.textOf
import org.bukkit.ChatColor

class ProjectNamePlugin : KotlinPlugin() {

    override fun onPluginEnable() {
        registerHelloCommand()
        registerComplexCommand()
    }

    private fun registerHelloCommand() = simpleCommand("hello") {
        sender.msg("world")
    }

    private fun registerComplexCommand() = command("complex") {
        permission = "projectname.cmd.complex"

        permissionMessage = ChatColor.RED + "You do not have access to this command."
        onlyInGameMessage = ChatColor.RED + "You can not use this command in console."

        executor {
            sender.msg("------ Project Name ------")
            sendSubCommandsList()
            sender.msg("------ Project Name ------")
        }

        command("a") {
            description = "The A subcommand"

            executor {
                val target = player(
                    index = 0,
                    argMissing = textOf("Please inform the target player."),
                    notOnline = textOf("This player is not online.")
                )

                target.msg("Hello A")
            }
        }

        command("b") {
            permission += ".b" // projectname.cmd.complex.b
            description = "The B subcommand"

            executorPlayer {
                sender.msg("Hello B")
            }
        }
    }
}