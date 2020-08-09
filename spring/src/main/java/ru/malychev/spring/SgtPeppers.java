package ru.malychev.spring;

import org.springframework.stereotype.Component;

@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisk {

    private final String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private final String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
