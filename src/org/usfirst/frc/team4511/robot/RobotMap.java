/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4511.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap { 
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	public static final int topLeftMotor = 1;
	public static final int topRightMotor = 4;
	public static final int bottomLeftMotor = 3;
	public static final int bottomRightMotor = 2;
	
	public static final int winchMotor = 5;
	//public static final int driverMotor = 6;
	public static final int succCubeUno = 6;
	public static final int succCubeDos = 7;
	
	public static final int huggerUno = 8;
	public static final int huggerDos = 9;
	
	public static final int lifterMotor = 10;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
