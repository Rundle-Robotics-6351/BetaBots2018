package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark climber = new Spark(RobotMap.Spark_Controller_Climber);
	
	public void setClimber(double speed) {
		climber.set(speed);

	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

