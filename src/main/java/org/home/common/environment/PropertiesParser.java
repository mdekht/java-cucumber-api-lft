package org.home.common.environment;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:src/main/resources/maven.properties")
public interface PropertiesParser extends Config {
    @Key("apiUrl")
    String apiUrl();
}
