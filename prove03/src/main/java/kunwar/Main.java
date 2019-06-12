package kunwar;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
     URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=b4d4258c3f3876775b39421c51a5c7ff");

//    URLConnection connection = new URL(url).openConnection();
////    connection.setRequestProperty("Accept-Charset", charset);
//    InputStream response = connection.getInputStream();
//
//       final Scanner scanner = new Scanner(response);
//        String responseBody = scanner.useDelimiter("\\A").next();
//        System.out.println("vvbv");


    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }


    public Main(String [] args) throws IOException {
        System.out.print(getResponseFromHttpUrl(url));
    }

}
