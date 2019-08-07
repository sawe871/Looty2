package com.derongan.minecraft.looty.registration;

import com.derongan.minecraft.looty.skill.proto.Skill;
import com.derongan.minecraft.looty.skill.proto.SkillTrigger;
import org.bukkit.entity.Player;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Handles registration of player skill types.
 */
@Singleton
public class PlayerSkillRegister {
    //    private Map<Player, Map<SkillTrigger, Skill>> playerSkillMap;
    //TODO make this work lol
    private final Map<SkillTrigger, Skill> playerSkillMap;

    @Inject
    PlayerSkillRegister() {
        playerSkillMap = new HashMap<>();
    }

    public Optional<Skill> getSkill(Player player, SkillTrigger skillTrigger) {
        return Optional.ofNullable(playerSkillMap.get(skillTrigger));
    }

    public void register(Player player, SkillTrigger trigger, Skill skill) {
        playerSkillMap.put(trigger, skill);
    }
}