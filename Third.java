import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Third {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            String search = scanner.nextLine();
            String text = getHTML("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + search);
            getCount(text, search);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getCount(String text, String search){
        int index = text.indexOf(search);
        int count = 0;
        while (index != -1) {
            count++;
            text = text.substring(index + 1);
            index = text.indexOf(search);
        }
        System.out.println(count);
        return count;
    }

    private static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}