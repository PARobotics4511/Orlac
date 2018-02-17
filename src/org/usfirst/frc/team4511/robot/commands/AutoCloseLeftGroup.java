package org.usfirst.frc.team4511.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCloseLeftGroup extends CommandGroup {
	
    public AutoCloseLeftGroup(double distance, double angle, double speed) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new AutoStraight(distance, speed));
    	addSequential(new AutoTurn(angle, speed));
    	//New edits start here
    	addSequential(new AutoLiftUp());
    	addSequential(new AutoHugRelease());
    	addSequential(new AutoStraight(-1, 0.6));
    	addSequential(new AutoLiftDown());
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
