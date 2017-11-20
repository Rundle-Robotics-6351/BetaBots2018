package org.usfirst.frc.team6351.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team6351.robot.RobotMap;

/**
 *
 */
public class Shooter extends Subsystem 
{

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Spark shooterWheel;
	
	public Shooter()
	{
		shooterWheel = new Spark(6);
	}
	
	public void fire()
	{
		shooterWheel.set(RobotMap.Spark_Controller_Shooter);
	}
	
	public void stop()
	{
		shooterWheel.set(0);
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

