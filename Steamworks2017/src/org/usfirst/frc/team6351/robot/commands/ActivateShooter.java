package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivateShooter extends Command {

    public ActivateShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sparks);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sparks.setShooter(-1.0);
    	Robot.sparks.setMixer(-0.8);
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
    	Robot.sparks.setShooter(0.0);
    	Robot.sparks.setMixer(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sparks.setShooter(0.0);
    	Robot.sparks.setMixer(0.0);
    }
}
