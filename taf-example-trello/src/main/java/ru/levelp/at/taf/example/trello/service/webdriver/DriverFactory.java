package ru.levelp.at.taf.example.trello.service.webdriver;

public enum DriverFactory {

    CHROME {
        @Override
        public DriverManager createInstance() {
            return new ChromeDriverManager();
        }
    },
    FIREFOX {
        @Override
        public DriverManager createInstance() {
            return new FirefoxDriverManager();
        }
    },
    EDGE {
        @Override
        public DriverManager createInstance() {
            return new EdgeDriverManager();
        }
    };

    public abstract DriverManager createInstance();
}
