package org.usfirst.frc.team6351.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team6351.robot.RobotMap;

/**
 * Max's super neat shooter subsystem :) this allows a motor to stop and go. That's pretty much it.
 */
public class Shooter extends Subsystem 
{

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Spark shooterWheel;
	
	public Shooter()
	{
		//Assigns shooter wheel to spot on the PCB.
		shooterWheel = new Spark(6);
	}
	
	public void slowSpeed()
	{
		//When this is activated, the motor spins at the same magnitude as set in RobotMap.
		shooterWheel.set(0.8);
	}
	public void fastSpeed()
	{
		//When this is activated, the motor spins at the same magnitude as set in RobotMap.
		shooterWheel.set(1.0);
	}
	
	
	public void stop()
	{
		//When this is activated, the motor stops doing stuff.
		shooterWheel.set(0);
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

