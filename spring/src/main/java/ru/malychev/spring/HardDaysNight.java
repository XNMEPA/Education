package ru.malychev.spring;

import org.springframework.stereotype.Component;

@Component("aHardDaysNight")
public class HardDaysNight implements CompactDisk {

    private final String title = "A Hard Day’s Night";
    private final String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing \"" + title + "\" by " + artist);
    }
}
