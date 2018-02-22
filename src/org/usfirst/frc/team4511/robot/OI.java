/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4511.robot;

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

	static Joystick gamepad = new Joystick(3);
	

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	
	static double deadzone = .1;
	
	public OI() {
		
		JoystickButton butt1 = new JoystickButton(stick1, 1);
		JoystickButton butt2 = new JoystickButton(stick2, 1);
		
		JoystickButton butt3 = new JoystickButton(stick1, 3);
		JoystickButton butt4 = new JoystickButton(stick2, 3);
		
		JoystickButton butt5 = new JoystickButton(stick1, 4);
		JoystickButton butt6 = new JoystickButton(stick2, 4);
		
		JoystickButton butt7 = new JoystickButton(stick1, 2);
		JoystickButton butt8 = new JoystickButton(stick2, 2);
		
		
		JoystickButton game1 = new JoystickButton(gamepad, 6); //left bumper
		JoystickButton game2 = new JoystickButton(gamepad, 7);  //right bumper
		
		JoystickButton gameX = new JoystickButton(gamepad, 3);
		JoystickButton gameB = new JoystickButton(gamepad, 4);
		
		//JoystickButton leftTrigger = new JoyStickTrigger()
		
		if(gamepad.getZ() > 0.75) { //left trigger
			new LiftUp();
		}
		
		if(gamepad.getZ() < 0.25) { //right trigger
			new LiftDown();
		}
		
		if(gamepad.getZ() == 0.50) {
			new LiftStop();
		}
		game1.whenPressed(new WinchUp());
		game2.whenPressed(new WinchDown());
		
		game1.whenReleased(new WinchStop());
		game2.whenReleased(new WinchStop());
		
		gameX.whenPressed(new HugRelease());
		gameB.whenPressed(new Hug());
		
		gameX.whenReleased(new HugStop());
		gameB.whenReleased(new HugStop());
		
		
		butt1.whenPressed(new WinchUp());
		butt2.whenPressed(new WinchDown());
		
		butt3.whenPressed(new LiftUp());
		butt4.whenPressed(new LiftDown());
		
		butt1.whenReleased(new WinchStop());
		butt2.whenReleased(new WinchStop());
		
		butt3.whenReleased(new LiftStop());
		butt4.whenReleased(new LiftStop());
		
		butt5.whenPressed(new SuccIn());
		butt6.whenPressed(new SuccOut());
		
		butt5.whenReleased(new SuccStop());
		butt6.whenReleased(new SuccStop());
		
		butt7.whenPressed(new Hug());
		butt8.whenPressed(new HugRelease());
		
		butt7.whenReleased(new HugStop());
		butt8.whenReleased(new HugStop());

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
	
	public static double getYInput3() {
		if (Math.abs(gamepad.getY()) > deadzone) {
			return -gamepad.getY();
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
