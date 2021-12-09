package ru.levelp.at.lesson12.design.pattern.factory;

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
