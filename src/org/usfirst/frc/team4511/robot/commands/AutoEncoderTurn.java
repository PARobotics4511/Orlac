package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.Robot;
import org.usfirst.frc.team4511.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoEncoderTurn extends Command {
	
	public double goDistance;
	public double goAngle;
	public double goSpeed;
	
	public double fractionOfCircle;
	public double wheelSpace = 14; //inches (radius)
    public AutoEncoderTurn(double degrees, double speed) {
    	   // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.soulTrain);
    	
    	goAngle = degrees; //degrees!
    	
    	//convert to radians
    	//goAngle = 2*3.14159 / goAngle; //radians
    	fractionOfCircle = goAngle / 360;
    	goSpeed = speed; //ranges -1 to 1
    }

    protected double getArcDistance(double goAngle) {
    	double circleCircumference = 2 * 3.14159 * wheelSpace;
    	SmartDashboard.putNumber("Fraction of circle to travel", fractionOfCircle);
    	double goDistance = circleCircumference * fractionOfCircle / 12;
    	SmartDashboard.putNumber("Arc length to travel", goDistance);
    	return Math.abs(goDistance);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Status:", "i SHALL move to the closest switch on the LEfT THANKS!!");
    }

    protected double averageDistance() {
    	double averageDist = DriveTrain.checkAverageEncoder();
    	return averageDist;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(goAngle >= 0) { //turn left (counterclockwise)
	    	while(true) {
	    	DriveTrain.drive(goSpeed, -goSpeed);
	    	//DriveTrain.checkLeftEncoder();
		    	if(DriveTrain.checkLeftEncoder() > getArcDistance(goAngle) || DriveTrain.checkLeftEncoder() < -getArcDistance(goAngle) ) {
		    		DriveTrain.drive(0, 0);
		    		isFinished();
		    		break;
		    	}
	    	}
    	} else { // turn right
	    	while(true) {
	    	DriveTrain.drive(goSpeed, -goSpeed);
	    	//DriveTrain.checkLeftEncoder();
		    	if(DriveTrain.checkLeftEncoder() > getArcDistance(goAngle) || DriveTrain.checkLeftEncoder() < -getArcDistance(goAngle) ) {
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
		DriveTrain.leftDriveEncoder.reset();
		DriveTrain.rightDriveEncoder.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
