package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.Robot;
import org.usfirst.frc.team4511.robot.subsystems.Hugger;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoHug extends Command {

    public AutoHug() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.hugger);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.hugger.autoHug();
    	/*Robot.hugger.hug();
        try{ 
        	Thread.sleep(1000);
        }catch(InterruptedException e){
        	Thread.currentThread().interrupt();	
        }*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.hugger.hugStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
