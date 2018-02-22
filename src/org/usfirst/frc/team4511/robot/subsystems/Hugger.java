package org.usfirst.frc.team4511.robot.subsystems;

import org.usfirst.frc.team4511.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Hugger extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static WPI_TalonSRX huggerLeft = new WPI_TalonSRX(RobotMap.huggerUno);
	public static WPI_TalonSRX huggerRight = new WPI_TalonSRX(RobotMap.huggerDos);
	
	public void hug() {
		huggerLeft.set(0.5);
		huggerRight.set(-0.5);
	}
	
	public void release() {
		huggerLeft.set(-0.5);
		huggerRight.set(0.5);
	}
	
	public void hugStop() {
		huggerLeft.set(0);
		huggerRight.set(0);
	}

	public void autoHug() {
		SmartDashboard.putString("Time to move to release?", "Nope!");
		while(true) {
			huggerLeft.set(0.5);
			huggerRight.set(-0.5);
			
			double leftHugDegrees = checkLeftEncoder();
			double rightHugDegrees = checkRightEncoder();
			
			if(leftHugDegrees > 120 && rightHugDegrees > 120) {
				huggerLeft.set(0);
				huggerRight.set(0);
				break;
			}
			
		}
	}
	
	public void autoRelease(){
		SmartDashboard.putString("Time to move to release?", "Yup!");
		
    	huggerLeft.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		huggerLeft.getSensorCollection().setQuadraturePosition(0, 10);
		
    	huggerRight.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		huggerRight.getSensorCollection().setQuadraturePosition(0, 10);
		
		
		while(true) {
			huggerLeft.set(-0.5);
			huggerRight.set(0.5);
			
			double leftHugDegrees = checkLeftEncoder();
			double rightHugDegrees = checkRightEncoder();
			
			if(leftHugDegrees > 120 && rightHugDegrees > 120) {
				huggerLeft.set(0);
				huggerRight.set(0);
				break;
			}
			
		}
	}
	public double checkLeftEncoder() {
		
		double startingPosition = 0; // degrees
		double grabbingPoint = 120; // degrees
		
		double huggerLeftDegrees = huggerLeft.getSelectedSensorPosition(0) / 4096.0 * 360.0;
		double huggerRightDegrees = huggerRight.getSelectedSensorPosition(0) / 4096.0 * 360.0;
		//swings out 14" bar
		//SmartDashboard.putNumber("HuggerUno rotations", huggerLeft.getSelectedSensorPosition(0) / 4096.0); //4096 units per rotation
		SmartDashboard.putNumber("Hugger Left position (degrees)", huggerLeftDegrees);
		
		//SmartDashboard.putNumber("HuggerDos rotations", huggerRight.getSelectedSensorPosition(0) / 4096.0); //4096 units per rotation
		SmartDashboard.putNumber("Hugger Right position (degrees)", huggerRightDegrees);
		
		return huggerLeftDegrees;
		/*double RPM = huggerUno.getSelectedSensorVelocity(0) * (600.0/4096.0);
		SmartDashboard.putNumber("Hugger RPM", RPM);
		double linearVelocity = 8.0 * 3.14159 / 12 * RPM / 60;
		SmartDashboard.putNumber("Hugger velocity", linearVelocity);
	
		//double linearVelocity = 6.0 * 60.0 * 3.141 * (2.0/3.0);
		//SmartDashboard.putNumber("Lifter Velocity (ft/s)", linearVelocity);
		//SmartDashboard.putNumber("Lifter Velocity lame type (ft/s)", lifterMotor.getSelectedSensorVelocity(0));
		
		/*lifterMotor.configForwardSoftLimitThreshold(10000, 0);
		lifterMotor.configReverseSoftLimitThreshold(-10000, 0);
		lifterMotor.configForwardSoftLimitEnable(true, 0);
		lifterMotor.configReverseSoftLimitEnable(true, 0);*/
		
	}
	
	public double checkRightEncoder() {
		double huggerRightDegrees = huggerRight.getSelectedSensorPosition(0) / 4096.0 * 360.0;
		return huggerRightDegrees;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	huggerLeft.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		huggerLeft.getSensorCollection().setQuadraturePosition(0, 10);
		
    	huggerRight.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		huggerRight.getSensorCollection().setQuadraturePosition(0, 10);
		
		
		
		
    }
}

