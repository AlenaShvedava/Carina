package pl.solvd.carina;

public enum Url {
    OVERVIEW("http://zebrunner.github.io/carina/"),
    GITHUB("https://github.com/zebrunner/carina/");
    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
