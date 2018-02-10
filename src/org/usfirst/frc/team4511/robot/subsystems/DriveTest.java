package org.usfirst.frc.team4511.robot.subsystems;

import org.usfirst.frc.team4511.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTest extends Subsystem {

	
	
    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
//	public static WPI_TalonSRX driverMotor = new WPI_TalonSRX(RobotMap.driverMotor);
	
	public static Encoder driveTestEncoder = new Encoder(0,1);
	
	//public static final double RPM = driverMotor.getSelectedSensorVelocity(0) * (600/4096);
	public static int count;
	public double distance;
	
	public static double driveRevolutions;
	
	public double distanceTraveled;
//	talon.setFeedbackDevice(FeedbackDevice.QuadEncoder); //Set the feedback device that is hooked up to the talon
//	talon.setPID(0.5, 0.001, 0.0); //Set the PID constants (p, i, d)
//	talon.enableControl(); //Enable PID control on the talon
//	int currentPosition = talon.getEncPosition();
//	System.out.println(currentPosition);
	//int currentCount = lifterEncoder.get();
	//System.out.println(currentCount);
	
	
	public static double checkDriveTestEncoder() {
		//6 inch wheels
		
		count = driveTestEncoder.get();
		SmartDashboard.putNumber("Toughbox Encoder", count); //360 cycles per revolution, 1440 pulses per revolution
		
		driveRevolutions = driveTestEncoder.getDistance() / 1440.0 * 3.14159 * 0.5;
		SmartDashboard.putNumber("Toughbox distance (ft)", driveRevolutions);
		
		return driveRevolutions;
		//SmartDashboard.putNumber("Lifter RPM", lifterMotor.getSelectedSensorVelocity(0)*(600/4096));
		//double linearVelocity = 6 * 60 * 3.141 * (2/3);
		//SmartDashboard.putDouble("Lifter Velocity (ft/s)", linearVelocity);
		//SmartDashboard.putNumber("Lifter Velocity (ft/s)", lifterMotor.getSelectedSensorVelocity(0));
		
		/*driverMotor.configForwardSoftLimitThreshold(10000, 0);
		driverMotor.configReverseSoftLimitThreshold(-10000, 0);
		driverMotor.configForwardSoftLimitEnable(true, 0);
		driverMotor.configReverseSoftLimitEnable(true, 0);*/
	}
	
	public double checkEncoderDistance() {
		distanceTraveled = driveTestEncoder.getDistance();
		return distanceTraveled;
	}
	
	
	/*public void goDistance() {
		
	}*/
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		/*driverMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		driverMotor.getSensorCollection().setQuadraturePosition(0, 10);*/
    	driveTestEncoder.setDistancePerPulse(4);

    }
}

