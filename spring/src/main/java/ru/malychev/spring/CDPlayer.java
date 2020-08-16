package ru.malychev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Pioneer")
public class CDPlayer implements MediaPlayer{
    private CompactDisk cd;

    @Autowired
    public void insertCD(CompactDisk cd) {
        this.cd = cd;
    }

    @Autowired
    public CDPlayer(CompactDisk cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
