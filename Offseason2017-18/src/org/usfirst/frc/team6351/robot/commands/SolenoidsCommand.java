package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SolenoidsCommand extends Command {

	Solenoid oneortwo;
	String operation;
	
    public SolenoidsCommand(Solenoid whichone, String operationString) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumatics);
    	
    	oneortwo = whichone;
        operation = operationString;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (operation == "extend") {
    		oneortwo.set(true);
    	} else if (operation == "retract") {
    		oneortwo.set(false);
    	}
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
