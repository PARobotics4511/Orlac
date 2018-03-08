package org.usfirst.frc.team4511.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCloseRightGroup extends CommandGroup {

    public AutoCloseRightGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new AutoLiftUp());
    	addSequential(new AutoHug());
    	addParallel(new AutoLiftUp()); //throw a parameter in there to specify how long it should lift for
    	addParallel(new AutoStraight(90, 0.6)); //start driving toward near switch
    	
    	addSequential(new AutoEncoderTurn(90, 0.6));
    	addSequential(new AutoStraight(12, 0.6));
    	addParallel(new AutoHugRelease());
    	addParallel(new AutoSuccOut());
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
