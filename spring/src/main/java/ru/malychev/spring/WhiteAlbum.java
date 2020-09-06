package ru.malychev.spring;

import org.springframework.stereotype.Component;

@Component("whiteAlbum")
public class WhiteAlbum implements CompactDisk {

    private final String title = "White Album";
    private final String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing \"" + title + "\" by " + artist);
    }
}
