package by.pw.crr.metla.engine;

import by.pw.crr.metla.entities.MetalareaRelease;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public enum MetalareaParser {

    INSTANCE;

    public List<MetalareaRelease> parseReleases() {
        List<MetalareaRelease> parsedReleases = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect("http://metalarea.org/forum/index.php?act=SF&f=2&st=0&changefilters=1")
                    .userAgent("Chrome/81.0.4044.138")
                    .referrer("http://www.google.com")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.select("div.borderwrap>table.ipbtable>tbody>tr>td.row1>div:not(:empty)");
        for (Element el : elements) {
            MetalareaRelease release = new MetalareaRelease(el.select("span a").text(),
                    el.select("span a").attr("href"),
                    el.select("div.desc span").text());
            parsedReleases.add(release);
        }
        return parsedReleases;
    }
}

