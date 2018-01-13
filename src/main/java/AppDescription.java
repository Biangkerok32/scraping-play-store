public class AppDescription {

    private final String nameApp;
    private final String linkDescription;
    private final String linkImg;

    public AppDescription(String nameApp, String linkDescription, String linkImg) {
        this.nameApp = nameApp;
        this.linkDescription = linkDescription;
        this.linkImg = linkImg;
    }

    public String getNameApp() {
        return nameApp;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public String getLinkImg() {
        return linkImg;
    }

    @Override
    public String toString() {
        return "AppDescription{" +
                "nameApp='" + nameApp + '\'' +
                ", linkDescription='" + linkDescription + '\'' +
                ", linkImg='" + linkImg + '\'' +
                '}';
    }
}
