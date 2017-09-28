
package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

/**
 * Rundle College Team 6351, 2017 Season
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class Pneumatics extends Subsystem {
	Compressor compressor;
	Solenoid s1;
	Solenoid s2;
	
	public Pneumatics(){
		compressor = new Compressor();
		s1 = new Solenoid(RobotMap.Solenoid_1);
		s2 = new Solenoid(RobotMap.Solenoid_2);

	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void start() {
		if (Robot.isReal()) {
			compressor.start();
			compressor.setClosedLoopControl(true);
			
		}
	}
    
/*
* Error Functions
*/
    
    public boolean getEnabled() {
    	return compressor.enabled();
    }
    public boolean getCurrentFault() {
    	return compressor.getCompressorCurrentTooHighFault();
    }
    public boolean getConnectionFault() {
    	return compressor.getCompressorNotConnectedFault();
    }
    public boolean getShortFault() {
    	return compressor.getCompressorShortedFault();
    }
    
/*
* Operation Functions
*/
    
    public void startCompressor() {
    	compressor.start();
    }
    public void stopCompressor() {
    	compressor.stop();
    }
    public void activateCylinder1(boolean op) {
    	s1.set(op);
    }
    public void activateCylinder2(boolean op) {
    	s2.set(op);
    }

}

