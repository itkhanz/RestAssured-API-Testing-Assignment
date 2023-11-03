package com.itkhanz.constants;

import com.itkhanz.config.owner.ConfigFactory;

/**
 * Stores all the endpoints, base urls, and base path parameters for APIs as constants
 */
public class Route {
  public static final String BASE_URI = ConfigFactory.getGeneralConfig().BASE_URL();
  public static final String BASE_PATH = "/geo/latestv2/cities";
  public static final String STREETS = "/streets";
}
