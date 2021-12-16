package ru.levelp.at.taf.example.trello.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

@LoadPolicy(LoadType.MERGE)
@Sources({"classpath:${env}/application.properties",
    "system:properties",
    "system:env"})
public interface ApplicationConfiguration extends Config {

    @Key("trello.base.url")
    String baseUrl();

    @Key("web.driver.wait.timeout.in.seconds")
    long webDriverWaitTimeoutInSeconds();

    @Key("browser.name")
    String browserName();

    @Key("trello.test.user.email")
    String testUserEmail();

    @Key("trello.test.user.password")
    String testPassword();

    static ApplicationConfiguration createConfig() {
        return ConfigFactory.create(ApplicationConfiguration.class);
    }
}
