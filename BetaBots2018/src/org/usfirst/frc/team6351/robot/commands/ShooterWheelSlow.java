package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;
import org.usfirst.frc.team6351.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Max's super neat shooter command :) This spins a wheel when a button is held. That's pretty much it.
 */
public class ShooterWheelSlow extends Command 
{

    public ShooterWheelSlow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	//When command is initialized, the motor activates
    	Robot.shooter.slowSpeed();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	//When the command ends, the motor stops going. Tricky, huh?
    	Robot.shooter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	//If something breaks, stop doing the thing please
    	Robot.shooter.stop();
    }
}
