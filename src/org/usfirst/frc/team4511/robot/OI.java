/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4511.robot;

import org.usfirst.frc.team4511.robot.commands.AutoHug;
import org.usfirst.frc.team4511.robot.commands.Hug;
import org.usfirst.frc.team4511.robot.commands.HugRelease;
import org.usfirst.frc.team4511.robot.commands.HugStop;
import org.usfirst.frc.team4511.robot.commands.LiftDown;
import org.usfirst.frc.team4511.robot.commands.LiftStop;
import org.usfirst.frc.team4511.robot.commands.LiftUp;
import org.usfirst.frc.team4511.robot.commands.SuccIn;
import org.usfirst.frc.team4511.robot.commands.SuccOut;
import org.usfirst.frc.team4511.robot.commands.SuccStop;
import org.usfirst.frc.team4511.robot.commands.WinchDown;
import org.usfirst.frc.team4511.robot.commands.WinchStop;
import org.usfirst.frc.team4511.robot.commands.WinchUp;

//import org.usfirst.frc.team4511.robot.commands.DriveTestDown;
//import org.usfirst.frc.team4511.robot.commands.DriveTestStop;
//import org.usfirst.frc.team4511.robot.commands.DriveTestUp;
//import org.usfirst.frc.team4511.robot.commands.LiftDown;
//import org.usfirst.frc.team4511.robot.commands.LiftStop;
//import org.usfirst.frc.team4511.robot.commands.LiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	static Joystick stick1 = new Joystick(0);
	static Joystick stick2 = new Joystick(1);
	static Joystick gamepad = new Joystick(2);
	
	

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	
	static double deadzone = .1;
	
	public OI() {
		JoystickButton leftTrigger = new JoystickButton(stick1, 1);
		JoystickButton rightTrigger = new JoystickButton(stick2, 1);
		
		JoystickButton leftThree = new JoystickButton(stick1, 3);
		JoystickButton rightThree = new JoystickButton(stick2, 3);
		
		JoystickButton butt5 = new JoystickButton(stick1, 5);
		JoystickButton butt6 = new JoystickButton(stick2, 4);
		
		JoystickButton butt7 = new JoystickButton(stick1, 2);
		JoystickButton butt8 = new JoystickButton(stick2, 2);
		
		JoystickButton y = new JoystickButton(gamepad, 4);
		JoystickButton a = new JoystickButton(gamepad, 1);
		
		JoystickButton leftBumper = new JoystickButton(gamepad, 5);
		JoystickButton rightBumper = new JoystickButton(gamepad, 6);

		JoystickButton gameLeftTrigger = new JoystickButton(gamepad, 7);
		JoystickButton gameRightTrigger = new JoystickButton(gamepad, 8);
		
		
		gameLeftTrigger.whenPressed(new WinchUp());
		gameRightTrigger.whenPressed(new WinchDown());
		
		gameLeftTrigger.whenReleased(new WinchStop());
		gameRightTrigger.whenReleased(new WinchStop());
		
		leftTrigger.whenPressed(new HugRelease());
		rightTrigger.whenPressed(new AutoHug());
		
		leftThree.whenPressed(new SuccOut());
		rightThree.whenPressed(new SuccIn());
		
		leftTrigger.whenReleased(new HugStop());
		//rightTrigger.whenReleased(new LiftStop());
		
		leftThree.whenReleased(new SuccStop());
		rightThree.whenReleased(new SuccStop());
		
		
		leftBumper.whenPressed(new LiftDown());
		rightBumper.whenPressed(new LiftUp());
		
		leftBumper.whenReleased(new LiftStop());
		rightBumper.whenReleased(new LiftStop());
		
		//butt5.whenPressed(new SuccIn());
		//butt6.whenPressed(new SuccOut());
		
		//butt5.whenReleased(new SuccStop()); //left stick
		//butt6.whenReleased(new SuccStop()); //right stick
		
		//butt7.whenPressed(new Hug());
		//butt8.whenPressed(new HugRelease());
		
		y.whenPressed(new Hug());
		a.whenPressed(new HugRelease());
		
		y.whenReleased(new HugStop());
		a.whenReleased(new HugStop());
		
		//butt7.whenReleased(new HugStop());
		//butt8.whenReleased(new HugStop());

	}

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	
	public static double getYInput() {
		if (Math.abs(stick1.getY()) > deadzone) {
			return -stick1.getY();
		}
		return 0;
	}
	public static double getYInput2() {
		if (Math.abs(stick2.getY()) > deadzone) {
			return -stick2.getY();
		}
		return 0;
	}

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
