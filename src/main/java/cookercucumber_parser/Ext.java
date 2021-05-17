package cookercucumber_parser;


public enum Ext {
    FEATURE(".feature"),
    JAVA(".java");

    public final String extension;

    Ext(String s) {
        this.extension = s;
    }
}
