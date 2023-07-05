package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nasa {

    private final String copyright, date, explanation,
            hdurl, mediaType, serviceVersion, title, url;

    public Nasa(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getHdurl() {
        return hdurl;
    }

    @Override
    public String toString() {
        return "{hdurl = " + hdurl + "}";
    }
}
