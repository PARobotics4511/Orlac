package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.Robot;
import org.usfirst.frc.team4511.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoStraight extends Command {
	
	public double goDistance;
	public double goSpeed;
	
    public AutoStraight(double distance, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.soulTrain);
    	goDistance = distance; //feet
    	goSpeed = speed; //ranges -1 to 1
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Status:", "i SHALL move to the closest switch on the LEfT THANKS!!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(goDistance >= 0) {
	    	while(true) {
		    	DriveTrain.drive(goSpeed, goSpeed);
		    	//DriveTrain.checkLeftEncoder();
		    	double avg = (DriveTrain.checkLeftEncoder() + DriveTrain.checkRightEncoder())/2;
		    	if(avg > goDistance || avg < -goDistance ) {
		    		DriveTrain.drive(0, 0);
		    		isFinished();
		    		break;
		    	}
	    	}
    	
    	} else { //go backwards if value given is negative
	    	while(true) {
		    	DriveTrain.drive(-goSpeed, -goSpeed);
		    	//DriveTrain.checkLeftEncoder();
		    	double avg = (Math.abs(DriveTrain.checkLeftEncoder()) + Math.abs(DriveTrain.checkRightEncoder()))/2;
		    	if(avg > goDistance || avg < -goDistance ) {
		    		DriveTrain.drive(0, 0);
		    		isFinished();
		    		break;
		    	}
	    	}
    	}
    	/*try{ 
        	Thread.sleep(7000);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
