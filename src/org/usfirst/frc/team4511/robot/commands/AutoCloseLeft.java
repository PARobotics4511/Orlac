package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.Robot;
import org.usfirst.frc.team4511.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCloseLeft extends Command {

    public AutoCloseLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.soulTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Status:", "i SHALL move to the closest switch on the LEfT THANKS!!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	

    	
    	DriveTrain.drive(0.9, 0.9);
    	//DriveTrain.checkLeftEncoder();
    	if(DriveTrain.checkLeftEncoder() > 3 || DriveTrain.checkLeftEncoder() < -3 ) {
    		DriveTrain.drive(0, 0);
    	}
    	
    	
    	
    	/*try{ 
        	Thread.sleep(7000);
        }catch(InterruptedException e){
        	Thread.currentThread().interrupt();	
        }*/
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
