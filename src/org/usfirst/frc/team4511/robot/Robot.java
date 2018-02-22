/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4511.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4511.robot.commands.AutoDrive;
import org.usfirst.frc.team4511.robot.commands.AutoFarLeftGroup;
import org.usfirst.frc.team4511.robot.commands.AutoFarRightGroup;
import org.usfirst.frc.team4511.robot.commands.AutoTurn;
import org.usfirst.frc.team4511.robot.commands.EvenNow;
import org.usfirst.frc.team4511.robot.commands.AutoStraight;
import org.usfirst.frc.team4511.robot.commands.AutoCloseLeftGroup;
import org.usfirst.frc.team4511.robot.commands.AutoCloseRightGroup;
import org.usfirst.frc.team4511.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4511.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4511.robot.subsystems.Hugger;
import org.usfirst.frc.team4511.robot.subsystems.Lifter;
import org.usfirst.frc.team4511.robot.subsystems.PhotoEye;
//import org.usfirst.frc.team4511.robot.subsystems.;
import org.usfirst.frc.team4511.robot.subsystems.Succ;
import org.usfirst.frc.team4511.robot.subsystems.Winch;

import java.lang.Object;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static final DriveTrain soulTrain = new DriveTrain();
	//public static final  pulseFront = new (3, 2);
	public static final Lifter lifty = new Lifter();
	/*public static final DriveTest drive = new DriveTest();
	*/
	public static final Succ succer = new Succ();
	public static final Hugger hugger = new Hugger();
	
	public static final Winch climber = new Winch();
	public double compass;
	/*public static final PhotoEye leftEye = new PhotoEye(2);
	public static final PhotoEye rightEye = new PhotoEye(3);
	public static final PhotoEye armEye = new PhotoEye(0);*/

	public Preferences prefs;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		prefs = Preferences.getInstance();
		
		double goCloseStraightDistance = prefs.getDouble("Autonomous Close Straight Distance", 3);
		double goFarStraightDistance = prefs.getDouble("Autonomous Far Straight Distance", 3);
		double rotateAngle = prefs.getDouble("Angle of rotation (- = left, + = right)", 90);
		double speed = prefs.getDouble("Speed", 0.6);
		
		/*m_chooser.addDefault("My Auto", new AutoDrive());
		m_chooser.addObject("Go Straight", new AutoStraight(goCloseStraightDistance, speed));
		
		m_chooser.addObject("Go Close Left Group", new AutoCloseLeftGroup(2, -90.0, 0.8));
		m_chooser.addObject("Go Close Right Group", new AutoCloseRightGroup(2, 90.0, 0.8));
		m_chooser.addObject("Go Far Right Group", new AutoFarRightGroup(4, 90.0, 0.8));
		m_chooser.addObject("Go Far Left Group", new AutoFarLeftGroup(4, -90.0, 0.8));
		
		
		
		
		m_chooser.addObject("EVEN NOW, THE EVIL SEED OF WHAT YOU'VE DONE GERMINATES WITHIN YOU.", new EvenNow());
		m_chooser.addObject("Auto Turn", new AutoTurn(rotateAngle, speed));*/
		SmartDashboard.putData("Auto mode", m_chooser);
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L') {
			m_chooser.addDefault("Go Left", new AutoCloseLeftGroup(3, 90, 0.7));
			SmartDashboard.putData("Auto mode", m_chooser);
		} else {
			m_chooser.addDefault("Go Right", new AutoCloseRightGroup(3, -90, 0.7));
			SmartDashboard.putData("Auto mode", m_chooser);
		}
		
		SmartDashboard.putData("Auto mode", m_chooser);
		
		CameraServer cam = CameraServer.getInstance();
	    cam.startAutomaticCapture("Cam", 0);
	    CameraServer cam2 = CameraServer.getInstance();
	    cam2.startAutomaticCapture("Cam2", 1);
	    
	    soulTrain.gyro.reset();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//Lifter.lifterMotor.getSensorCollection().setQuadraturePosition(0, 10);
		soulTrain.gyro.reset();
		//drive.driveTestEncoder.reset();
		soulTrain.leftDriveEncoder.reset();
		soulTrain.rightDriveEncoder.reset();
		
		Hugger.huggerLeft.getSensorCollection().setQuadraturePosition(0, 10);
		Hugger.huggerRight.getSensorCollection().setQuadraturePosition(0, 10);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
		soulTrain.checkLeftEncoder();
		
		Scheduler.getInstance().run();
		
		compass = soulTrain.gyro.getAngle();
		if(compass > 360.0 || compass < -360.0) {
			soulTrain.gyro.reset();
		}
		
		SmartDashboard.putNumber("Gyro value", soulTrain.gyro.getAngle());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		/*if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}*/
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//lifty.checkEncoder();
		//drive.checkDriveTestEncoder();
		soulTrain.checkLeftEncoder();
		
		hugger.checkLeftEncoder(); //outputs relevant data to SmartDashboard
		
		hugger.checkRightEncoder();
		compass = soulTrain.gyro.getAngle();
		if(compass > 360.0 || compass < -360.0) {
			soulTrain.gyro.reset();
		}
		
		SmartDashboard.putNumber("Gyro value", soulTrain.gyro.getAngle());
		/*if (Lifter.lifterMotor.getSelectedSensorVelocity(0) * (600.0/4096.0) > 5 ) {
			SmartDashboard.putBoolean("Is this working?", true);
		} else {
			SmartDashboard.putBoolean("Is this working?", false);
		}*/
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
