package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivateServo extends Command {

	double speed;
	
    public ActivateServo(double speedVariable) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.servos);
    	
    	speed = speedVariable;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.servos.gateServo.set(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.servos.gateServo.set(0.01);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.servos.gateServo.set(0.01);
    }
}
