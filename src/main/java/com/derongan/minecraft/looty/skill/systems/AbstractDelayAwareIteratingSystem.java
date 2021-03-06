package com.derongan.minecraft.looty.skill.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.derongan.minecraft.looty.skill.component.EntityTargetLimit;
import com.derongan.minecraft.looty.skill.component.Movement;
import com.derongan.minecraft.looty.skill.component.Targeting;
import com.derongan.minecraft.looty.skill.component.Volume;
import com.derongan.minecraft.looty.skill.component.components.ActionAttributes;
import com.derongan.minecraft.looty.skill.component.components.EntityTargets;
import com.derongan.minecraft.looty.skill.component.components.LingerInternal;
import com.derongan.minecraft.looty.skill.component.components.Targets;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.derongan.minecraft.looty.skill.component.components.Families.IGNORABLE;

public abstract class AbstractDelayAwareIteratingSystem extends IteratingSystem {
    protected final Logger logger;
    protected ComponentMapper<Targeting> targetingComponentMapper = ComponentMapper.getFor(Targeting.class);
    protected ComponentMapper<ActionAttributes> actionAttributesComponentMapper = ComponentMapper.getFor(ActionAttributes.class);
    protected ComponentMapper<Targets> targetComponentMapper = ComponentMapper.getFor(Targets.class);
    protected ComponentMapper<Movement> movementComponentMapper = ComponentMapper.getFor(Movement.class);
    protected ComponentMapper<EntityTargets> entityTargetsComponentMapper = ComponentMapper.getFor(EntityTargets.class);
    protected ComponentMapper<Volume> volumeComponentMapper = ComponentMapper.getFor(Volume.class);
    protected ComponentMapper<EntityTargetLimit> entityTargetLimitComponentMapper = ComponentMapper.getFor(EntityTargetLimit.class);
    protected ComponentMapper<LingerInternal> persistComponentMapper = ComponentMapper.getFor(LingerInternal.class);


    public AbstractDelayAwareIteratingSystem(Logger logger, Family family) {
        super(family);
        this.logger = logger;
    }

    public AbstractDelayAwareIteratingSystem(Logger logger, Family family, int priority) {
        super(family, priority);
        this.logger = logger;
    }

    @Override
    final protected void processEntity(Entity entity, float deltaTime) {
        if (!IGNORABLE.matches(entity)) {
            try {
                processFilteredEntity(entity, deltaTime);
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Error encountered updating entity. Removing", e);
                getEngine().removeEntity(entity);
            }
        }
    }

    protected abstract void processFilteredEntity(Entity entity, float deltaTime);
}
