package org.usfirst.frc.team4511.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoEscapeCenterLeft extends CommandGroup {
	
	//use this regardless of whether you're crossing the baseline or going for the lift or switch
	
    public AutoEscapeCenterLeft() {
    	//For getting out of the center when you're blocked by all of the other robots and you're really really scared and you don'
    	//t know what to do and everything is blurry and yeah
    	
    	//--PICK UP BLOCK---
    	addSequential(new AutoLiftUp());
    	addSequential(new AutoHug());
    	addParallel(new AutoLiftUp()); //throw a parameter in there to specify how long it should lift for
    	
    	//--START MOVIN---
    	addParallel(new AutoEncoderTurn(90, 0.5));
    	addSequential(new AutoStraight(120, 0.7));
    	addSequential(new AutoEncoderTurn(-90, 0.5));
    	addSequential(new AutoStraight(50, 0.7));
    	
    	//lets you snake through that stuff and layer up some other commands
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

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
