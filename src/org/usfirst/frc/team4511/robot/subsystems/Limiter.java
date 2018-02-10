package org.usfirst.frc.team4511.robot.subsystems;

import org.usfirst.frc.team4511.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Limiter extends Subsystem {
	
	
	Counter counter;
	DigitalInput limitSwitch;
	
	public Limiter(int port) {
		limitSwitch = new DigitalInput(port);
		counter = new Counter(port);
	}
	
	
	public static WPI_TalonSRX limitLift = new WPI_TalonSRX(RobotMap.lifterMotor);
	
	public boolean isSwitchSet() {
		SmartDashboard.putBoolean("Limit Switch set?", !limitSwitch.get());
		return !limitSwitch.get();
	}
	
	public void initializeCounter() {
		SmartDashboard.putBoolean("Counter initialized", true);
		counter.reset();
	}
	
	public void limitLiftUp() {
		SmartDashboard.putString("Lift status", "Lifted up!");
		limitLift.set(0.5);
	}
	
	public void limitLiftDown() {
		SmartDashboard.putString("Lift status", "Lifted up!");
		limitLift.set(0.5);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

