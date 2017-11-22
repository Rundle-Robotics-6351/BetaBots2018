package org.usfirst.frc.team6351.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team6351.robot.RobotMap;

public class LightRing extends Subsystem 
{

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Spark lightRing;
	
	public LightRing()
	{
		lightRing = new Spark(9);
	}
	
	public void on()
	{
		lightRing.set(0.7);
	}
	
	public void off()
	{
		lightRing.set(0);
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

