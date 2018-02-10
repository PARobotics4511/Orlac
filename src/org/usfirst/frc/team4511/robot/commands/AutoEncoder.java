package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.Robot;
import org.usfirst.frc.team4511.robot.subsystems.DriveTest;
import org.usfirst.frc.team4511.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoEncoder extends Command {
	
	public double distance;
	
    public AutoEncoder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.soulTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*distance = DriveTest.checkDriveTestEncoder();
    	if(distance < 60.0 || distance > -60.0) {
    		DriveTest.driverMotor.set(0.9);
    	} else {
    		try{
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
        		Thread.currentThread().interrupt();
        	}
    	} */
    	
    	while(Math.abs(DriveTest.checkDriveTestEncoder()) < 60 /* || DriveTest.checkDriveTestEncoder() > -60 */) {
    		//SmartDashboard.putNumber("Oh god what is happening", DriveTest.checkDriveTestEncoder());
    		DriveTest.driverMotor.set(-0.9);
    	}
    	try{
			Thread.sleep(10);
		} catch (InterruptedException e) {
    		Thread.currentThread().interrupt();
    	}
    	//DriveTest.driverMotor.set(0.0);
    	//isFinished();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	DriveTest.driverMotor.set(0.0);;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
