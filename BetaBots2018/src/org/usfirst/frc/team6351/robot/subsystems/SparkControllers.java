package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SparkControllers extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Spark shooter = new Spark(RobotMap.Spark_Controller_Shooter);
	Spark mixer = new Spark(RobotMap.Spark_Controller_HopperMixer);
	
	public void setShooter(double speed) {
		shooter.set(speed);
	}
	public void setMixer(double speed) {
		mixer.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

