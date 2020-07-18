package by.pw.crr.metla.engine;

import by.pw.crr.metla.entities.MetalareaRelease;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetalareaParser {



//
//    public Document parseReleases() {
//        Document document = null;
//        try {
//            document = Jsoup.connect("http://metalarea.org/forum/index.php?act=SF&f=2&st=0&changefilters=1")
//                    .userAgent("Chrome/81.0.4044.138")
//                    .referrer("http://www.google.com")
//                    .get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return document;
//    }
//
//    public List<MetalareaRelease> getNewReleases(Document document) {
//        List<MetalareaRelease> newReleases = new ArrayList<>();
//        Elements releaseElements = document.select("span[id^=tid-]");
//        for (int i = 0; i < releaseElements.size(); i += 2) {
//            newReleases.add(new MetalareaRelease(releaseElements.get(i), releaseElements.get(i + 1)));
//        }
//        return newReleases;
//    }
//
//    public List<MetalareaRelease> refresh() {
//        List<MetalareaRelease> freshReleases = new ArrayList<>();
//        Document document = parseReleases();
//        Elements releaseElements = document.select("span[id^=tid-]");
//        for (int i = 0; i < releaseElements.size(); i += 2) {
//            MetalareaRelease releaseBuffer = new MetalareaRelease(releaseElements.get(i), releaseElements.get(i + 1));
//            if (!releases.contains(releaseBuffer)) {
//                freshReleases.add(releaseBuffer);
//            }
//        }
//        releases = getNewReleases(document);
//        return freshReleases;
//    }
}

