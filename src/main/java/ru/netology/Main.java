package ru.netology;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;


public class Main {

    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=qDDu3vEUX0dAdQ3IIFudIFEJ454v8usOgYPiShjr");
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        CloseableHttpResponse response = httpClient.execute(request);

        Nasa nasa = mapper.readValue(response.getEntity().getContent(), Nasa.class);
        System.out.println(nasa.toString());

        request = new HttpGet(nasa.getHdurl());
        response = httpClient.execute(request);

        FileOutputStream fos = new FileOutputStream(nasa.getHdurl().split("/")[6]);
        response.getEntity().writeTo(fos);

        response.close();
        httpClient.close();
    }
}