package com.itkhanz.config.owner;

import org.aeonbits.owner.ConfigCache;

public class ConfigFactory {
    public static GeneralConfig getGeneralConfig() {
        return ConfigCache.getOrCreate(GeneralConfig.class);
    }
}
