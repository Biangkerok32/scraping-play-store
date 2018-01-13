

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public final static String URL = "https://play.google.com/store/search?q=xizuth&c=apps&hl=en";

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect(URL).get();

        List<String> apps_names = document.select("a.title").eachText();

        List<String> apps_links = document.select("a.title").eachAttr("href");
        final String urlPlayStore = "https://play.google.com";
        ArrayList<String> links = new ArrayList<>();
        for (String s: apps_links) {
            links.add(urlPlayStore+s);
        }

        List<String > urlImagen = document.select(".cover-image").eachAttr("src");

        for (String s :
                apps_names) {
            System.out.println("Name app:" +s);
        }
        for (String s : links) {
            System.out.println("Link: " +s);
        }

        for (String s: urlImagen) {
            System.out.println("Imagen url: " + "https:"+s);
        }
    }

    private static List<String> generateLinks(List<String> links) {

        return links;
    }
}
