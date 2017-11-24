package org.usfirst.frc.team6351.autocommands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Rundle College Team 6351, 2017/18 Season
 * Programmed in Java by Davis Carlson
 * 
 */

public class AutoDriveToContour extends Command {

	double xPosition;
	double area;
	double centerX = RobotMap.MJPEG_WIDTH/2;
	double offset;
	
    public AutoDriveToContour() {
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
    		area = Robot.areaContour;
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
        	
        	if (offset >= -7 && offset <= 7) {
        		Robot.driveTrain.setLeft(0);
        		Robot.driveTrain.setRight(0);
        	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		if (offset >= -7 && offset <= 7) {
    			if (area / (RobotMap.MJPEG_HEIGHT*RobotMap.MJPEG_WIDTH) > 0.2) {
    				Robot.driveTrain.setLeft(-0.3);
        			Robot.driveTrain.setRight(0.3);
        			
        			Timer.delay(0.4);
        			
        			Robot.driveTrain.setLeft(0);
        			Robot.driveTrain.setRight(0);
        			
        			return true;
    			} else {
    				return false;
    			}
    		} else {
    			return false;
    		}
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveTrain.setLeft(0);
		Robot.driveTrain.setRight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		Robot.driveTrain.setLeft(0);
		Robot.driveTrain.setRight(0);
    }
}
