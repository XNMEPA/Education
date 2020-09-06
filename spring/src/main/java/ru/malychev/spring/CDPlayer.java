package ru.malychev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("pioneer")
public class CDPlayer implements MediaPlayer{
    private CompactDisk cd;

    @Autowired
    public CDPlayer insertCD(@Qualifier("beatlesCDs") CompactDisk cd) {
        this.cd = cd;
        return this;
    }

    public CDPlayer() { }

    @Override
    public void play() {
        cd.play();
    }
}
