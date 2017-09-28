package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallCollector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Spark spinner = new Spark(RobotMap.Spark_Controller_Spinner);
	
	public void setBallCollector(double speed) {
		spinner.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

