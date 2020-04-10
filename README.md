# KBAPI-StarterProject

A simple starter project for Minecraft Spigot Plugin using [KotlinBukkitAPI](https://github.com/DevSrSouza/KotlinBukkitAPI/).

The starter comes with the following KotlinBukkitAPI modules by default.
- core
- architecture

Any other modules needed, just undocument at `build.gradle.kts` at dependencies section.

# Starting a new project

On Windows, open Git Bash, on Mac or Linux just open a terminal.
Run the following command bellow changing the `PROJECT_NAME` to your project name.

```shell script
PROJECT_NAME="NameOfYourProject" && git clone https://github.com/KotlinMinecraft/KBAPI-StarterProject.git $PROJECT_NAME && rm -rf $PROJECT_NAME/.git && rm $PROJECT_NAME/README.md
```

# How to configure it

### Project Name 
Update `rootProject.name` at `settings.gradle.kts`.

### Project Package
Update the `group` at `build.gradle.kts` to your project package.

### plugin.yml

The project autos generate the `plugin.yml` using [plugin-yml gradle plugin](https://github.com/Minecrell/plugin-yml).

To configure it, just go to `build.gradle.kts` at `bukkit` section.

Default Main Class definition: `"${project.group}.${project.name.toLowerCase()}.${project.name}Plugin"`
