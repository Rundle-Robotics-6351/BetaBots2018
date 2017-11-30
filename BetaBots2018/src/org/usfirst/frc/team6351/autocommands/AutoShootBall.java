package org.usfirst.frc.team6351.autocommands;

import org.usfirst.frc.team6351.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShootBall extends Command {

    public AutoShootBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	requires(Robot.servos);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.servos.gateServo.set(0.49);
    	Robot.shooter.fire();
    	Timer.delay(0.4);
    	Robot.servos.gateServo.set(0.90);
    	Timer.delay(1.0);
    	Robot.shooter.stop();  
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
