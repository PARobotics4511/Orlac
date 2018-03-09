package org.usfirst.frc.team4511.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoEscapeCenterRight extends CommandGroup {
	//want it to move so that it doesn't collide with other robots
    public AutoEscapeCenterRight() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	//--PICK UP BLOCK---
    	/*addSequential(new AutoLiftUp());
    	addSequential(new AutoHug());
    	addParallel(new AutoLiftUp());*/ //throw a parameter in there to specify how long it should lift for
    	
    	//--START MOVIN---
    	addSequential(new AutoEncoderTurn(70, 0.7));
    	addSequential(new AutoStraight(10, 0.7));
    	addSequential(new AutoEncoderTurn(430, 0.7));
    	addSequential(new AutoStraight(10, 0.7));
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
