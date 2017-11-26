package org.usfirst.frc.team6351.autocommands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

/**
 * Rundle College Team 6351, 2017 Season
 * Programmed in Java by Davis Carlson
 * 
 */

public class AutoAlignToContour extends Command {

	double xPosition;
	double centerX = 240;
	double offset;
	
	
    public AutoAlignToContour() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	xPosition = Robot.centerXContour;
    	offset = centerX - xPosition;
    
    	if (xPosition != 0) {
    		if (offset < 0.0 && offset > -RobotMap.MJPEG_WIDTH/4) {
        		Robot.driveTrain.setLeft(0.1);
        		Robot.driveTrain.setRight(0.1);
        	} 
        	if (offset < 0.0 && offset < -RobotMap.MJPEG_WIDTH/4) {
        		Robot.driveTrain.setLeft(0.1);
        		Robot.driveTrain.setRight(0.1);
        	}
        	if (offset > 0.0 && offset < RobotMap.MJPEG_WIDTH/4) {
        		Robot.driveTrain.setLeft(-0.1);
        		Robot.driveTrain.setRight(-0.1);
        	} 
        	if (offset > 0.0 && offset > RobotMap.MJPEG_WIDTH/4) {
        		Robot.driveTrain.setLeft(-0.1);
        		Robot.driveTrain.setRight(-0.1);
        	}
        	
        	if (offset >= -3 && offset <= 3) {
        		Robot.driveTrain.setLeft(0);
        		Robot.driveTrain.setRight(0);
        	}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (offset >= -3 && offset <= 3) {
    		return true;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
