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
public class Lifter extends Subsystem {

	
	
    //Limit switch stuff

	
	//Top Limit Switch
	DigitalInput topLimitSwitch = new DigitalInput(7);
	Counter counterTop = new Counter(topLimitSwitch);
	
	//Bottom Limit switch
	DigitalInput bottomLimitSwitch = new DigitalInput(9);
	Counter counterBottom = new Counter(bottomLimitSwitch);
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static WPI_TalonSRX lifterMotor = new WPI_TalonSRX(RobotMap.lifterMotor);
	
	
	//public static final double RPM = lifterMotor.getSelectedSensorVelocity(0) * (600.0/4096.0);
	
	public double RPM;
	
	public double linearVelocity;
//	talon.setFeedbackDevice(FeedbackDevice.QuadEncoder); //Set the feedback device that is hooked up to the talon
//	talon.setPID(0.5, 0.001, 0.0); //Set the PID constants (p, i, d)
//	talon.enableControl(); //Enable PID control on the talon
//	int currentPosition = talon.getEncPosition();
//	System.out.println(currentPosition);
	//int currentCount = lifterEncoder.get();
	//System.out.println(currentCount);
	
	//-----Top Limit----------------
	public boolean isTopSwitchSet() {
		return counterTop.get() > 0;
		//SmartDashboard.putBoolean("Switch Set?", !topLimitSwitch.get());
		
	}
	
	public void initializeTopCounter() {
		counterTop.reset();
	}
	
	
	
	//-----Bottom Limit---------------
	public boolean isBottomSwitchSet() {
		return counterBottom.get() > 0;
	}
	
	public void initializeBottomCounter() {
		counterBottom.reset();
	}
	
	public void liftStop() {
		lifterMotor.set(0.0);
	}
	
	public void liftUp() {
		lifterMotor.set(0.5);
	}
	
	public void liftDown() {
		lifterMotor.set(-0.5);
	}
	
	/*public void winchUp() {
		
	}*/
	
	public void checkEncoder() {
		
		SmartDashboard.putNumber("Top Limit switch count", (double)counterTop.get());
		SmartDashboard.putNumber("Lifter position weee", lifterMotor.getSelectedSensorPosition(0) * 2.0); //4096 units per rotation
		
		RPM = lifterMotor.getSelectedSensorVelocity(0) * (600.0/4096.0);
		SmartDashboard.putNumber("Lifter RPM", RPM);
		linearVelocity = 8.0 * 3.14159 / 12 * RPM / 60;
		SmartDashboard.putNumber("Lifter velocity", linearVelocity);
		
		
		//double linearVelocity = 6.0 * 60.0 * 3.141 * (2.0/3.0);
		//SmartDashboard.putNumber("Lifter Velocity (ft/s)", linearVelocity);
		//SmartDashboard.putNumber("Lifter Velocity lame type (ft/s)", lifterMotor.getSelectedSensorVelocity(0));
		
		/*lifterMotor.configForwardSoftLimitThreshold(10000, 0);
		lifterMotor.configReverseSoftLimitThreshold(-10000, 0);
		lifterMotor.configForwardSoftLimitEnable(true, 0);
		lifterMotor.configReverseSoftLimitEnable(true, 0);*/
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		lifterMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		lifterMotor.getSensorCollection().setQuadraturePosition(0, 10);

    }
}

