package org.usfirst.frc.team6351.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Servos extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Servo gateServo;
	
	public Servos() {
		 gateServo = new Servo(5);
		 gateServo.set(0.01);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

//    public void openGate() {
//    	gateServo.set(0.5);
//    }
//    public void closeGate() {
//    	gateServo.set(0);
//    }
    public double getServoPosition() {
    	return gateServo.getPosition();
    }
}

