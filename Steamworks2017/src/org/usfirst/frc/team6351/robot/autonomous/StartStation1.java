package org.usfirst.frc.team6351.robot.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6351.robot.commands.*;

/**
 *
 */
public class StartStation1 extends CommandGroup {

    public StartStation1() {
    	DriverStation.Alliance color;
    	color = DriverStation.getInstance().getAlliance();
    	if (color == DriverStation.Alliance.Blue){
    		addSequential(new AutoDriveStraight(0.4,2));
//        	addSequential(new AutoTurn(-90));
//        	addSequential(new AutoDriveStraight(0.6,2.5));
//        	addSequential(new AutoTurn(-90));
//        	addSequential(new AutoDriveStraight(0.3,2));
//        	addSequential(new AutoTurn(-45));
//        	addSequential(new ActivateShooter());
    	} else if(color == DriverStation.Alliance.Red){
    		addSequential(new AutoDriveStraight(0.4,2));
//    		addSequential(new AutoDriveStraight(0.6,3));
//        	addSequential(new AutoTurn(-90));
//        	addSequential(new AutoDriveStraight(0.6,2.5));
//        	addSequential(new AutoTurn(-90));
//        	addSequential(new AutoDriveStraight(0.3,2));
//        	addSequential(new AutoTurn(-45));
//        	addSequential(new ActivateShooter());
    	}
    	
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
