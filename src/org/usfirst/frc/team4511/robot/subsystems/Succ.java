package org.usfirst.frc.team4511.robot.subsystems;

import org.usfirst.frc.team4511.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

//Luc says: "why sipp when you can succ"
//Stay in school, kids.

/**
 *
 */
public class Succ extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static WPI_TalonSRX succCubeUno = new WPI_TalonSRX(RobotMap.succCubeUno);
	public static WPI_TalonSRX succCubeDos = new WPI_TalonSRX(RobotMap.succCubeDos);
	
	public void succIn() {
		succCubeUno.set(-0.5);
		succCubeDos.set(-0.5);
	}
	
	public void succOut() {
		succCubeUno.set(0.5);
		succCubeDos.set(0.5);
	}
	
	public void succStop() {
		succCubeUno.set(0);
		succCubeDos.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

