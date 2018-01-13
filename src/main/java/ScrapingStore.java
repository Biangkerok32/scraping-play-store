import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScrapingStore {

    private static ScrapingStore scrapingStore;
    private static Document document;
    private List<String> links, appsNames, linkImgs;

    private ScrapingStore(String URL_TO_SCRAP) throws IOException {
        document = Jsoup.connect(URL_TO_SCRAP).get();
    }

    public static ScrapingStore getInstance(String url) throws IOException {

        if (scrapingStore == null || document == null) {
            scrapingStore = new ScrapingStore(url);
        }

        return scrapingStore;
    }

    private void generateLinks() {
        List<String> apps_links = document.select("a.title").eachAttr("href");

        final String urlPlayStore = "https://play.google.com";

        ArrayList<String> links = new ArrayList<>();
        for (String s : apps_links) {
            links.add(urlPlayStore + s);
        }
        this.links = links;
    }

    private void generateNameApps() {
        this.appsNames = document.select("a.title").eachText();
    }

    private void generateLinksImgagen() {
        List<String> links = document.select(".cover-image").eachAttr("src");
        List<String> linksFull = new ArrayList<>();

        for (String l : links) {
            linksFull.add("https:" + l);
        }

        this.linkImgs = linksFull;
    }

    public List<AppDescription> getAppsDescription(){
        List<AppDescription> apps = new ArrayList<>();

        scrapingStore.generateNameApps();
        scrapingStore.generateLinks();
        scrapingStore.generateLinksImgagen();

        for (int i = 0; i < this.appsNames.size(); i++) {
            apps.add(
                    new AppDescription(appsNames.get(i), links.get(i), linkImgs.get(i))
            );
        }

        return apps;
    }
}
