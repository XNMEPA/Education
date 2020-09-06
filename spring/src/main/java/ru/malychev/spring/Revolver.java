package ru.malychev.spring;

import org.springframework.stereotype.Component;

@Component("revolver")
public class Revolver implements CompactDisk {

    private final String title = "Revolver";
    private final String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing \"" + title + "\" by " + artist);
    }
}
