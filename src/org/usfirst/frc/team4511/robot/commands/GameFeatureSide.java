package org.usfirst.frc.team4511.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
import edu.wpi.first.wpilibj.command.ConditionalCommand;
import openrio.powerup.MatchData;

public class GameFeatureSide extends ConditionalCommand {
    MatchData.GameFeature gameFeature;

    public GameFeatureSide(MatchData.GameFeature gameFeature, Command onLeft, Command onRight) {
        super(onLeft, onRight);

        this.gameFeature = gameFeature;
    }

    @Override
    protected boolean condition() {
        System.out.println(gameFeature.name() + ": " + MatchData.getOwnedSide(gameFeature).name());

        return MatchData.getOwnedSide(gameFeature) == MatchData.OwnedSide.LEFT;
    }
}