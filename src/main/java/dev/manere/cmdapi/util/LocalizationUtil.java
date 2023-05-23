package dev.manere.cmdapi.util;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Utility class for handling localization files and retrieving localized strings.
 */
public class LocalizationUtil {
    private static YamlConfiguration config;

    /**
     * Loads a localization file from the specified file name.
     * If the file does not exist, it is copied from the resource folder.
     *
     * @param fileName The name of the localization file.
     */
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

    /**
     * Retrieves the localized string for the specified key.
     * The string is colorized using ColorUtils.
     *
     * @param key The key of the localized string.
     * @return The localized string.
     */
    public static String getLocalizedString(String key) {
        String localizedString = config.getString(key);
        if (localizedString != null) {
            return ColorUtils.translate(localizedString);
        }
        return "";
    }

    /**
     * Retrieves the localized string for the specified key, with placeholders replaced.
     * The string is colorized using ColorUtils.
     *
     * @param key          The key of the localized string.
     * @param placeholders The placeholders and their replacements.
     * @return The localized string with placeholders replaced.
     */
    public static String getLocalizedString(String key, String... placeholders) {
        String localizedString = config.getString(key);
        if (localizedString != null) {
            localizedString = ColorUtils.translate(localizedString);
            for (int i = 0; i < placeholders.length; i += 2) {
                localizedString = localizedString.replace(placeholders[i], placeholders[i + 1]);
            }
            return localizedString;
        }
        return "";
    }

    /**
     * Retrieves the configuration section with the specified key from the localization file.
     *
     * @param key The key of the configuration section.
     * @return The configuration section.
     */
    public static ConfigurationSection getConfigSection(String key) {
        return config.getConfigurationSection(key);
    }
}
