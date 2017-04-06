package org.usfirst.frc.team6351.robot.autonomousRed;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6351.robot.commands.*;

/**
 *
 */
public class StartStation2Red extends CommandGroup {

    public StartStation2Red() {
    	
    	addSequential(new AutoDriveStraight(0.3,2));
    	Timer.delay(13);
//    	addSequential(new AutoDriveStraight(-0.6,1));
//    	addSequential(new AutoTurn(-90));
//    	addSequential(new AutoDriveStraight(0.6,2));
//    	addSequential(new AutoTurn(90));
//    	addSequential(new AutoDriveStraight(0.6,2));
//    	addSequential(new AutoTurn(-135));
//    	addSequential(new AutoDriveStraight(0.3,1.5));
//    	addSequential(new ActivateShooter());
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
