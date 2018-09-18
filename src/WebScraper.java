import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countWordUsingSplit(String input, String word) {
        int wordOccurence = 0;
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] words = input.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if(word.toLowerCase().equals(words[i].toLowerCase())) {
                wordOccurence++;
            }
        }
        return wordOccurence;
    }

    public static void main(String[] args) {
        System.out.println(countWordUsingSplit(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Prince"));
        System.out.println(countWordUsingSplit(urlToString("https://www.bls.gov/tus/charts/chart9.txt"), "Data"));
        System.out.println(countWordUsingSplit(urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"),"Data"));
    }
}
