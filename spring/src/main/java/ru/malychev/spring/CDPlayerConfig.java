package ru.malychev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MediaPlayer.class)
public class CDPlayerConfig {
    @Bean(name = "beatlesCDs")
    public CompactDisk randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);
        switch (choice) {
            case 0:
                return new SgtPeppers();
            case 1:
                return new WhiteAlbum();
            case 2:
                return new HardDaysNight();
            default:
                return new Revolver();
        }
    }

    @Bean(name = "pioneer")
    @Autowired
    public MediaPlayer pioneerCDPlayer(@Qualifier("beatlesCDs") CompactDisk cd) {
        return new CDPlayer().insertCD(cd);
    }
}
