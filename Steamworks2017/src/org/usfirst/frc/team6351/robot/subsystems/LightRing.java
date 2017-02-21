package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LightRing extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Talon ring = new Talon(RobotMap.Talon_Controller_LightRing);
	
	public void setLight(double speed) {
		ring.set(speed);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

