package org.usfirst.frc.team4511.robot.subsystems;

import org.usfirst.frc.team4511.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hugger extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static WPI_TalonSRX huggerUno = new WPI_TalonSRX(RobotMap.huggerUno);
	public static WPI_TalonSRX huggerDos = new WPI_TalonSRX(RobotMap.huggerDos);
	
	public void hug() {
		huggerUno.set(-0.5);
		huggerDos.set(-0.5);
	}
	
	public void release() {
		huggerUno.set(0.5);
		huggerDos.set(0.5);
	}
	
	public void hugStop() {
		huggerUno.set(0);
		huggerDos.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

