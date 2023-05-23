package dev.manere.cmdapi.util;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class LocalizationUtil {
    private static YamlConfiguration config;

    public static void loadLocalizationFile(String fileName) {
        File configFile = new File(fileName);
        if (!configFile.exists()) {
            try (InputStream is = LocalizationUtil.class.getResourceAsStream("/" + fileName)) {
                if (is != null) {
                    Path outputPath = configFile.toPath();
                    Files.copy(is, outputPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static String getLocalizedString(String key) {
        String localizedString = config.getString(key);
        if (localizedString != null) {
            return ChatColor.translateAlternateColorCodes('&', localizedString);
        }
        return "";
    }

    public static String getLocalizedString(String key, String... placeholders) {
        String localizedString = config.getString(key);
        if (localizedString != null) {
            localizedString = ChatColor.translateAlternateColorCodes('&', localizedString);
            for (int i = 0; i < placeholders.length; i += 2) {
                localizedString = localizedString.replace(placeholders[i], placeholders[i + 1]);
            }
            return localizedString;
        }
        return "";
    }

    public static ConfigurationSection getConfigSection(String key) {
        return config.getConfigurationSection(key);
    }
}
