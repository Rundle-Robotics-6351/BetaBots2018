package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InvertFrontBack extends Command {

    public InvertFrontBack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cameraDriveInverted = true;
    	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(1);
        camera.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
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
    	Robot.cameraDriveInverted = false;
    	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
        camera.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.cameraDriveInverted = false;
    	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
        camera.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
    }
}
