package com.itkhanz.config.owner;

import org.aeonbits.owner.ConfigCache;

/**
 * Creates Configuration Objects for Properties via Owner Library
 * You can create multiple methods inside to create separate Properties Objects for different properties files
 */
public class ConfigFactory {
    public static GeneralConfig getGeneralConfig() {
        return ConfigCache.getOrCreate(GeneralConfig.class);
    }
}
