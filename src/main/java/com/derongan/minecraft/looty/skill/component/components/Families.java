package com.derongan.minecraft.looty.skill.component.components;

import com.badlogic.ashley.core.Family;
import com.derongan.minecraft.looty.skill.component.Delay;

public class Families {
    public static final Family ALL_ENTITIES = Family.exclude().get();

    public static final Family REMOVABLE = Family.exclude(LingerInternal.class, DelayInternal.class, Delay.class)
            .get();

    public static final Family IGNORABLE = Family.one(DelayInternal.class, Delay.class).get();
}
