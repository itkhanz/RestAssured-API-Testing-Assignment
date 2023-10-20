package com.itkhanz.constants;

import com.itkhanz.config.owner.ConfigFactory;

public class Route {
    public static final String BASE_URI = ConfigFactory.getGeneralConfig().BASE_URL();
    public static final String BASE_PATH = "/geo/latestv2/cities";
    public static final String STREETS = "/streets";
}
