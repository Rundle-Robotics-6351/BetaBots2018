package org.usfirst.frc.team6351.autocommands;

import org.usfirst.frc.team6351.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Rundle College Team 6351, 2017/18 Season
 * Programmed in Java by Davis Carlson
 * 
 */

public class AutoDriveStraightUntilContour extends Command {

	double spd, tme;
	
    public AutoDriveStraightUntilContour(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.driveTrain);
    		spd = speed;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.driveTrain.setLeft(spd);
    		Robot.driveTrain.setRight(-spd);
    		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double xPosition = Robot.centerXContour;  
    		if (xPosition == 0) {
    			if (Timer.getMatchTime() > 5.0) {
    				return false;
    			}
    			return false;
    		}
    		else {
    			return true;
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
