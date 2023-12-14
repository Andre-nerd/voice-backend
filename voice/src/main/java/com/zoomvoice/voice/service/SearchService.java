package com.zoomvoice.voice.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SearchService {
    String userAgentName = "String userAgentName = USER_AGENT";
    public static final int TIME_OUT = 10000;

    public List<String> parseYahoo() {
        return indexOnePage("https://www.yahoo.com/");
    }
    public int[] countYahoo(){
//
//        List<String> urls = indexOnePage("https://ru.wikipedia.org/wiki/Example");
//        for(String url:urls){
//           count += countPage(url);
//        }

           return countPage("https://en.wikipedia.org/wiki/Portal:Current_events#2023_December_1");
    }

    private List<String> indexOnePage(String path) {
        List<String> listUrl = new ArrayList<>();
        try {
            Connection connection = Jsoup.connect(path)
                    .userAgent(userAgentName)
                    .timeout(TIME_OUT);
            Document doc = connection.get();
            Elements elements = doc.select("body").select("a");
            for (Element a : elements) {
                String childUrl = a.absUrl("abs:href");
                log.info(childUrl);
                listUrl.add(childUrl);
            }

        } catch (Exception ex) {
            log.info("Error > IndexingService fun indexOnePage" + ex);
        }
        return listUrl;
    }
    private int[] countPage(String url){
        int[] listChar = new int[128];
        Integer count = 0;
        try {
            Connection connection = Jsoup.connect(url)
                    .userAgent(userAgentName)
                    .timeout(TIME_OUT);
            Document doc = connection.get();
            String text = doc.body().text();
            log.info("TEXT: " + text);
            char[] charArray = text.toCharArray();
            for(Character ch:charArray){
                int code = (int) ch;
                if (code <= 127 ){
                    listChar[code]++;
                    count++;
                }
            }
//            Elements elements = doc.select("body").select("a");
//            for (Element a : elements) {
//                String text = a.absUrl("abs:p");
//                log.info("TEXT: " + text);
//            }

        } catch (Exception ex) {
            log.info("Error > IndexingService fun indexOnePage" + ex);
        }
        return listChar;
    }
//    public HashMap<String, Integer> parsingOnePageText(String pageText){
//        List<String> sourceTextList = splitTextIntoWords(pageText);
//        List<String> filterText = sourceTextList.stream().filter(TextParsing::isNotServicePart).toList();
//        System.out.println(filterText);
//        HashMap<String, Integer> map = parsingText(filterText);
//        return map;
//    }
}
