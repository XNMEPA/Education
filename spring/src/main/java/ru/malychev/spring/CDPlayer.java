package ru.malychev.spring;

import org.springframework.beans.factory.annotation.Autowired;

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

    public void play(CompactDisk cd) {
        cd.play();
    }
}
