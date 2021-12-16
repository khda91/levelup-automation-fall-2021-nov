package ru.levelp.at.taf.example.trello.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.levelp.at.taf.example.trello.configuration.ApplicationConfiguration;
import ru.levelp.at.taf.example.trello.model.TrelloUser;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TrelloUserDataProvider {

    public static TrelloUser getDefaultTrelloUser() {
        ApplicationConfiguration configuration = ApplicationConfiguration.createConfig();
        return TrelloUser.builder()
            .userEmail(configuration.testUserEmail())
            .userPassword(configuration.testPassword())
                         .build();
    }
}
