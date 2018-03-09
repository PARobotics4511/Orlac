package org.usfirst.frc.team4511.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStraightWithBlock extends CommandGroup {
	
	//for when you want to pass the baseline and still have a block with you for when teleop begins
    public AutoStraightWithBlock() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	//addSequential(new AutoLiftUp());
    	//addSequential(new AutoHug());
    	//addParallel(new AutoLiftUp()); //throw a parameter in there to specify how long it should lift for
    	addSequential(new AutoStraight(10, 0.7)); //pass the baseline
    	
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
