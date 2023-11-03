package com.itkhanz.config.owner;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:general.properties"})
public interface GeneralConfig extends Config {
  /****************** general.properties ******************/
  @Config.Key("base.url")
  String BASE_URL();
}
