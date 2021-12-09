package ru.levelp.at.lesson12.design.pattern.builder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class UserRequest {

    private final String email;
    private final String name;
    private final String password;

    public UserRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public static UserRequestBuilder builder() {
        return new UserRequestBuilder();
    }

    public static class UserRequestBuilder {

        private String email;
        private String name;
        private String password;

        public UserRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserRequest build() {
            return new UserRequest(email, name, password);
        }
    }
}
