package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.Robot;
import org.usfirst.frc.team4511.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoTurn extends Command {

	public double turnAngle;
	public double goSpeed;
	
	public double turnDistance;
	
	//if angle input is positive, go clockwise (turn right). if it's negative, go counter-clockwise (turn left)
    public AutoTurn(double angle, double speed) { //Clockwise turn (to the right) = + gyro reading, Counter-clockwise turn (to the left) = - gyro reading
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.soulTrain);
    	turnAngle = angle;
    	goSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.soulTrain.gyro.reset();
    }

    
    
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	    if(turnAngle <= 0) { //turn right
	    	//Robot.soulTrain.gyro.reset();
	    	DriveTrain.leftDriveEncoder.reset();
	    	DriveTrain.rightDriveEncoder.reset();
	    	
	    	turnDistance = DriveTrain.giveTurnDistance(-turnAngle);
	    	while(true) {
	    		
		    	DriveTrain.drive(goSpeed, -goSpeed);
		    	SmartDashboard.putString("Time to move to the right?", "Yes it is");
		    	
		    	double leftDistance = DriveTrain.checkLeftEncoder();
		    	double rightDistance = DriveTrain.checkRightEncoder();
		    	if(leftDistance > turnDistance || Math.abs(rightDistance) > turnDistance) {
		    		SmartDashboard.putString("Time to move to the right?", "it's time for us to stop");
		    		DriveTrain.drive(0, 0);
		    		isFinished();
		    		break;
		    	}
		    	/*if(-Robot.soulTrain.gyro.getAngle() < turnAngle) {
		    		SmartDashboard.putString("Time to move to the right?", "it's time for us to stop");
		    		DriveTrain.drive(0, 0);
		    		isFinished();
		    		break;
		    	}*/
	    	}
	    } else {
	    	//Robot.soulTrain.gyro.reset();
	    	DriveTrain.leftDriveEncoder.reset();
	    	DriveTrain.rightDriveEncoder.reset();
	    	turnDistance = DriveTrain.giveTurnDistance(-turnAngle);
	    	
	    	while(true) { //turn left
	    		
		    	DriveTrain.drive(-goSpeed, goSpeed);
		    	SmartDashboard.putString("Time to move to the right?", "Nope!");
		    	
		    	double leftDistance = DriveTrain.checkLeftEncoder();
		    	double rightDistance = DriveTrain.checkRightEncoder();
		    	if(rightDistance > turnDistance || Math.abs(leftDistance) > turnDistance) {
		    		SmartDashboard.putString("Time to move to the right?", "it's time for us to stop");
		    		DriveTrain.drive(0, 0);
		    		isFinished();
		    		break;
		    	}
		    	
		    	
		    	/*if(Math.abs(Robot.soulTrain.gyro.getAngle()) > turnAngle) {
		    		DriveTrain.drive(0, 0);
		    		isFinished();
		    		break;
		    	}*/
	    	}
	    }
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
