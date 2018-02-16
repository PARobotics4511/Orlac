package org.usfirst.frc.team4511.robot.subsystems;

import org.usfirst.frc.team4511.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static WPI_TalonSRX climberMotor = new WPI_TalonSRX(RobotMap.winchMotor);
	
	public void winchStop() {
		climberMotor.set(0.0);
	}
	
	public void winchUp() {
		climberMotor.set(0.5);
	}
	
	public void winchDown() {
		climberMotor.set(-0.5);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

