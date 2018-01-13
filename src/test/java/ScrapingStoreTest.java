import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ScrapingStoreTest {


    @Test
    public void listApps() {
        try {
            ScrapingStore scrapingStore;
            scrapingStore = ScrapingStore.getInstance("https://play.google.com/store/search?q=xizuth%20inc&c=apps&hl=es");

            List<AppDescription> listApps = scrapingStore.getAppsDescription();

            assertEquals("No is the same name app", "Nto", listApps.get(0).getNameApp());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void sizeListAppTest() {
        try {
            ScrapingStore scrapingStore;
            scrapingStore = ScrapingStore.getInstance("https://play.google.com/store/search?q=xizuth%20inc&c=apps&hl=es");

            List<AppDescription> listApps = scrapingStore.getAppsDescription();

            assertEquals("No is the size apps", 4, listApps.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
