package com.derongan.minecraft.looty.skill.component.effective;


//TODO implement and protoize
public class Sound implements com.badlogic.ashley.core.Component {
    private final org.bukkit.Sound sound;
    private final SoundLocation soundLocation;
    private final int volume;

    public enum SoundLocation {
        TARGET,
        ORIGIN
    }

    private Sound(org.bukkit.Sound sound, SoundLocation soundLocation, int volume) {
        this.sound = sound;
        this.soundLocation = soundLocation;
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public org.bukkit.Sound getSound() {
        return sound;
    }

    public SoundLocation getSoundLocation() {
        return soundLocation;
    }

    public static Sound create(org.bukkit.Sound sound, SoundLocation soundLocation, int volume) {
        return new Sound(sound, soundLocation, volume);
    }
}
