package Logic.Database.EditDatabase;


public abstract class DBConfig {

    static final String URL = "";
    static final String NAME = "";
    static final String PASSWORD = "";

    protected String getUrl() {
        return URL;
    }

    protected String getName() {
        return NAME;
    }

    protected String getPassword() {
        return PASSWORD;
    }
}
