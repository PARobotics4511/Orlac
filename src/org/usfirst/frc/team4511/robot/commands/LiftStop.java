package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.Robot;
import org.usfirst.frc.team4511.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftStop extends Command {

    public LiftStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lifty);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Lifter.lifterMotor.set(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
