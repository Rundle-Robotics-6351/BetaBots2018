
package org.usfirst.frc.team6351.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6351.robot.Robot;

/**
 *
 */

/**
 * Rundle College Team 6351, 2017 Season
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class AutoDoNotMove extends Command {

	double wait;
	
    public AutoDoNotMove(double waittime) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        wait = waittime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//WARNING: THIS IS A TESTING METHOD ONLY. THE ROBOT SHOULD NOT BE PROGRAMMED TO
    	//MOVE AT ANY POINT
    	Timer.delay(wait);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
