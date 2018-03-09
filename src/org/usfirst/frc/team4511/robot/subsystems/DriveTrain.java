/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4511.robot.subsystems;

import org.usfirst.frc.team4511.robot.RobotMap;

import org.usfirst.frc.team4511.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	
	//Encoder stuff
	public static Encoder leftDriveEncoder = new Encoder(4,5);
	public static Encoder rightDriveEncoder = new Encoder(2,3);
	
	public static int lCount;
	public static int rCount;
	
	public double distance;
	
	public static double lDriveDistance;
	public static double rDriveDistance;
	
	public static double distanceTraveled;
	
	
	public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.topLeftMotor);
	public static WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.topRightMotor);
	public static WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.bottomLeftMotor);
	public static WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.bottomRightMotor);
	
	public static double checkRightEncoder() {
		rCount = rightDriveEncoder.get();
		rDriveDistance = rightDriveEncoder.getDistance() / 1440.0 * 3.14159 * 0.5 / 12; //let's make it inches actually
		
		SmartDashboard.putNumber("Right Motor Distance (in)", rDriveDistance);
		return rDriveDistance;
	}
	public static double checkLeftEncoder() {
		//6 inch wheels
		
		SmartDashboard.putNumber("Left count", leftDriveEncoder.get());
		SmartDashboard.putNumber("Right count", rightDriveEncoder.get()); //right encoder doesn't work I am Saddened.
		
		lCount = leftDriveEncoder.get();
		//SmartDashboard.putNumber("Left Motor", lCount); //360 cycles per revolution, 1440 pulses per revolution
		
	
		lDriveDistance = -leftDriveEncoder.getDistance() / 1440.0 * 3.14159 * 0.5; //ft
		SmartDashboard.putNumber("Left Motor Distance (in)", lDriveDistance);
		return lDriveDistance;
		
		
	}
	
	public static double checkAverageEncoder() {
		
		rDriveDistance = leftDriveEncoder.getDistance() / 1440.0 * 3.14159 * 0.5; //inches

		lDriveDistance = leftDriveEncoder.getDistance() / 1440.0 * 3.14159 * 0.5; //inches

		SmartDashboard.putNumber("Left distance (in)", lDriveDistance);
		
		double averageDistance = lDriveDistance + rDriveDistance / 2;
		
		SmartDashboard.putNumber("Average Distance", averageDistance);
		
		return averageDistance;
		//SmartDashboard.putNumber("Lifter RPM", lifterMotor.getSelectedSensorVelocity(0)*(600/4096));
		//double linearVelocity = 6 * 60 * 3.141 * (2/3);
		//SmartDashboard.putDouble("Lifter Velocity (ft/s)", linearVelocity);
		//SmartDashboard.putNumber("Lifter Velocity (ft/s)", lifterMotor.getSelectedSensorVelocity(0));
		
		/*driverMotor.configForwardSoftLimitThreshold(10000, 0);
		driverMotor.configReverseSoftLimitThreshold(-10000, 0);
		driverMotor.configForwardSoftLimitEnable(true, 0);
		driverMotor.configReverseSoftLimitEnable(true, 0);*/
	}
	
	public static double checkLeftDistance() {
		distanceTraveled = leftDriveEncoder.getDistance();
		return distanceTraveled;
	}
	
	
	@SuppressWarnings("deprecation")
	public DriveTrain() {
		roboD.setSafetyEnabled(false);
	}
	
	

	@SuppressWarnings("deprecation")
	public static final SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
	public static final SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
	public static DifferentialDrive roboD = new DifferentialDrive(left, right);
	//static RobotDrive roboD = new RobotDrive(frontLeft, frontRight, backLeft, backRight);
	
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());
		leftDriveEncoder.setDistancePerPulse(4);
	}
	
	@SuppressWarnings("deprecation")
	public static void drive(double stick1, double stick2) {
		roboD.tankDrive((0.7*stick1),(0.7* stick2));
	}
	
}
