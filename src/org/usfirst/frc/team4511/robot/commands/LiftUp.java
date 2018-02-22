package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.OI;
import org.usfirst.frc.team4511.robot.Robot;
import org.usfirst.frc.team4511.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

//Things that have been commented out relate to the limit switch functionality
public class LiftUp extends Command {

    public LiftUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lifty);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.lifty.initializeTopCounter();
    	//Robot.lifty.liftUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lifty.liftUp(1);
    	
    	//Robot.lifty.checkEncoder();
    	//Encoder lifterEncoder = new Encoder(3, 4, true, EncodingType.k4X);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
        //return Robot.lifty.isTopSwitchSet();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lifty.liftStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
