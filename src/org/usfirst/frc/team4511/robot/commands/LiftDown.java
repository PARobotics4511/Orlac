//package org.usfirst.frc.team4511.robot.commands;
//
//import org.usfirst.frc.team4511.robot.Robot;
//import org.usfirst.frc.team4511.robot.subsystems.Lifter;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class LiftDown extends Command {
//
//    public LiftDown() {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	requires(Robot.lifty);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	Robot.lifty.initializeBottomCounter();
//    	Robot.lifty.liftDown();
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return Robot.lifty.isBottomSwitchSet();
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	Robot.lifty.liftStop();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	end();
//    }
//}
