package org.usfirst.frc.team6351.autocommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRoutine1 extends CommandGroup {

    public AutoRoutine1() {
    	addSequential(new AutoDriveStraight(0.5, 0.45));
    	addSequential(new AutoDoNotMove(2));
    	addSequential(new AutoTurn(-10));
    	addSequential(new AutoDoNotMove(1));
    	addSequential(new AutoDriveStraight(0.5, 0.25));
    	addSequential(new AutoShootBall());
    	addSequential(new AutoDriveStraight(-0.5, 0.3));
    	
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
