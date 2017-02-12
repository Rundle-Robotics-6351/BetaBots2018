package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FlightStickDrive extends Command {

    public FlightStickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double joystickX = Robot.oi.joystickAxisValue(RobotMap.Joy_X_Axis);
    	double joystickY = Robot.oi.joystickAxisValue(RobotMap.Joy_Y_Axis);
    	
    	double leftMotors = (joystickY - joystickX)*RobotMap.GTA_Drive_Scaling_Teleop;
    	double rightMotors = (joystickY + joystickX)*RobotMap.GTA_Drive_Scaling_Teleop*(-1);
    	
    	if (leftMotors > RobotMap.TELEOP_MAX_ROBOT_SPEED) {
 		   
    		leftMotors = RobotMap.TELEOP_MAX_ROBOT_SPEED;
    		   
    	}
    	if (rightMotors > RobotMap.TELEOP_MAX_ROBOT_SPEED) {
    		   
    		rightMotors = RobotMap.TELEOP_MAX_ROBOT_SPEED;
    		   
    	}
    	   if (leftMotors < RobotMap.TELEOP_MIN_ROBOT_SPEED) {
    		   
    		leftMotors = RobotMap.TELEOP_MIN_ROBOT_SPEED;
    		   
    	}
    	if (rightMotors < RobotMap.TELEOP_MIN_ROBOT_SPEED) {
    		   
    		rightMotors = RobotMap.TELEOP_MIN_ROBOT_SPEED;
    		   
    	}
    	Robot.driveTrain.setLeft(leftMotors);
    	Robot.driveTrain.setRight(rightMotors);
    	
    	SmartDashboard.putNumber("FlighStick LEFT", leftMotors);
    	SmartDashboard.putNumber("FlighStick RIGHT", rightMotors);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
