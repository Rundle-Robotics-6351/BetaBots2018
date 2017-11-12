package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InvertRobot extends Command {

    public InvertRobot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cameraDriveInverted = true;
    	
    	//MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
//    	Robot.usbCamera2.setResolution(RobotMap.MJPEG_WIDTH, RobotMap.MJPEG_HEIGHT);
//    	Robot.usbCamera1.setResolution(RobotMap.BACKUPMJPEG_WIDTH, RobotMap.BACKUPMJPEG_HEIGHT);
//        Robot.mjpegServer1.setSource(Robot.usbCamera2);
//        Robot.mjpegServer2.setSource(Robot.usbCamera1);
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
    	Robot.cameraDriveInverted = false;
//    	MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
//    	Robot.usbCamera1.setResolution(RobotMap.MJPEG_WIDTH, RobotMap.MJPEG_HEIGHT);
//    	Robot.usbCamera2.setResolution(RobotMap.BACKUPMJPEG_WIDTH, RobotMap.BACKUPMJPEG_HEIGHT);
//    	Robot.mjpegServer1.setSource(Robot.usbCamera1);
//    	Robot.mjpegServer2.setSource(Robot.usbCamera2);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.cameraDriveInverted = false;
//    	MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
//    	Robot.usbCamera1.setResolution(RobotMap.MJPEG_WIDTH, RobotMap.MJPEG_HEIGHT);
//    	Robot.usbCamera2.setResolution(RobotMap.BACKUPMJPEG_WIDTH, RobotMap.BACKUPMJPEG_HEIGHT);
//    	Robot.mjpegServer1.setSource(Robot.usbCamera1);
//    	Robot.mjpegServer2.setSource(Robot.usbCamera2);
    }
}
