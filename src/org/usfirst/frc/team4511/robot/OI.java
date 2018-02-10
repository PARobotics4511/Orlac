/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4511.robot;

//import org.usfirst.frc.team4511.robot.commands.DriveTestDown;
//import org.usfirst.frc.team4511.robot.commands.DriveTestStop;
//import org.usfirst.frc.team4511.robot.commands.DriveTestUp;
//import org.usfirst.frc.team4511.robot.commands.LiftDown;
//import org.usfirst.frc.team4511.robot.commands.LiftStop;
//import org.usfirst.frc.team4511.robot.commands.LiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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

	
	

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	
	static double deadzone = .1;
	
	public OI() {
		JoystickButton butt1 = new JoystickButton(stick1, 1);
		JoystickButton butt2 = new JoystickButton(stick2, 1);
		
		JoystickButton butt3 = new JoystickButton(stick1, 3);
		JoystickButton butt4 = new JoystickButton(stick2, 3);
		
		/*butt1.whenPressed(new LiftUp());
		butt2.whenPressed(new LiftDown());
		
		butt3.whenPressed(new DriveTestUp());
		butt4.whenPressed(new DriveTestDown());
		
		butt1.whenReleased(new LiftStop());
		butt2.whenReleased(new LiftStop());
		
		butt3.whenReleased(new DriveTestStop());
		butt4.whenReleased(new DriveTestStop());*/

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
