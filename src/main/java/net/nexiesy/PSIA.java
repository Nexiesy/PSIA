package net.nexiesy;


import lombok.Getter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class PSIA {

    @Getter
    public PSIAServer server;
    public PSIA(String url){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(url);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = null;
        try {
            assert httpResponse != null;
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            content = result.toString();
        } catch (UnsupportedOperationException | IOException e) {
            e.printStackTrace();
        }

        String information = getInformationHtml(content);
        List<String> players = Arrays.asList(information.split("Online Players")[1].split("FIND")[0].split(", "));
        server = format(information.split("About")[3].split("Registered")[0], information.split("Statistics")[2].split("Share")[0], players);
    }

    public PSIAServer format(String about, String stats, List players){
        String address = about.split("Address")[1].split("Status")[0].split("Hostname")[0].replace(" ", "");
        String hostname = about.split("Hostname")[1].split("Status")[0].replace(" ", "");
        String status = about.split("Status")[1].split("Players")[0].replace(" ", "");
        String oplayers = about.replace("Hostname"+hostname, "").split("Players")[1].split("Location")[0].replace(" ", "");
        String location = about.split("Location")[1].split("Version")[0].replace(" ", "");
        String version = about.split("Version")[1].split("Website")[0].replace(" ", "");
        String website = about.split("Website")[1].replace(" ", "");

        String[] datas = stats.split(" ");
        return new PSIAServer(address, hostname, status, oplayers, location, version, website, datas[2], Integer.parseInt(datas[4]), Integer.parseInt(datas[6]), Integer.parseInt(datas[8]), Integer.parseInt(datas[10]), Integer.parseInt(datas[12]), players);
    }

    private String getInformationHtml(String content){
        Elements information = Jsoup.parse(content).getAllElements();
        return information.get(1).text();
    }
}
