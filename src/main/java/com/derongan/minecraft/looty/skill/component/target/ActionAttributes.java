package com.derongan.minecraft.looty.skill.component.target;

import com.derongan.minecraft.looty.DynamicLocation;
import com.derongan.minecraft.looty.skill.component.Component;
import com.derongan.minecraft.looty.skill.component.InternalComponent;
import org.bukkit.util.Vector;

// TODO rename?
@InternalComponent
public class ActionAttributes implements Component {
    public Vector referenceHeading;
    public DynamicLocation initiatorLocation;
    public DynamicLocation impactLocation;
}
