//package org.usfirst.frc.team4511.robot.commands;
//
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
//import org.usfirst.frc.team4511.robot.Robot;
//import org.usfirst.frc.team4511.robot.subsystems.Sonar;
///**
// *
// */
//public class GetSonar extends Command {
//
//    public GetSonar() {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	requires(Robot.pulseFront);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	Robot.pulseFront.testReadings();
//    	SmartDashboard.putNumber("Sonar value", Robot.pulseFront.testReadings());
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}