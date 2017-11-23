package org.usfirst.frc.team6351.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team6351.robot.commands.FlightStickDrive;
import org.usfirst.frc.team6351.robot.commands.GTADrive;
import org.usfirst.frc.team6351.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6351.robot.subsystems.LightRing;
import org.usfirst.frc.team6351.robot.subsystems.Pneumatics;
import org.usfirst.frc.team6351.robot.subsystems.Sensors;
import org.usfirst.frc.team6351.robot.subsystems.Servos;
import org.usfirst.frc.team6351.robot.subsystems.SparkControllers;
import org.usfirst.frc.team6351.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

/**
 * Rundle College Team 6351, 2017 Season
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Sensors sensors = new Sensors();
	public static final Servos servos = new Servos();
	public static final SparkControllers sparks = new SparkControllers();
	public static final Shooter shooter = new Shooter();
	public static final LightRing light = new LightRing();
	public static OI oi;

    Command autonomousStart;
    Command teleopStart;
    SendableChooser<Command> autoMode;
    SendableChooser<Command> driveMode;

	public static double centerXContour;
	public static double centerYContour;
	public static double areaContour;
	NetworkTable GRIPContourReport;
	
	public static UsbCamera cameraUnder;
	public static MjpegServer mjpegServer1;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
    public void robotInit() {
    	GRIPContourReport = NetworkTable.getTable("GRIP/Yellow");

    	cameraUnder = new UsbCamera("USB Camera 0", 0);
    	cameraUnder.setResolution(RobotMap.MJPEG_WIDTH, RobotMap.MJPEG_HEIGHT);
    	cameraUnder.setFPS(30);
        mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
        mjpegServer1.setSource(cameraUnder);

        

		oi = new OI();
		
		//Autonomous Command Selector
		
		autoMode = new SendableChooser<Command>();
		//autoMode.addObject("Auto: Turn 90", new AutoTurn(90));
		//autoMode.addObject("Auto: Follow GRIP Contour (Shape)", new AutoFollowContour());
		//autoMode.addDefault("Auto: DO NOT MOVE", new AutoDoNotMove());
        SmartDashboard.putData("Auto mode", autoMode);
        
      //Drive Mode Command Selector
        
       driveMode = new SendableChooser<Command>();
       driveMode.addObject("Flight Stick Control", new FlightStickDrive());
       driveMode.addDefault("Two Person GTA Control", new GTADrive());
       SmartDashboard.putData("Drive Control Mode", driveMode);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	autonomousStart = (Command) autoMode.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousStart != null) autonomousStart.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

        getGRIP();
        //SmartDashboard.putNumber("AUTO TEXT GRIP X", Robot.centerXContour);
        //System.out.print(Robot.centerXContour);
        SmartDashboard.putNumber("Gyro Angle", sensors.getGyroAngle());
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousStart != null) autonomousStart.cancel();
        
        teleopStart = (Command) driveMode.getSelected(); 
        teleopStart.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run(); 
        SmartDashboard.putNumber("Gyro Angle", sensors.getGyroAngle());
        SmartDashboard.putNumber("Servo Position", servos.getServoPosition());
        
        getGRIP();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void getGRIP() {
    	double[] yValue = new double[0];
    	double[] xValue = new double[0];
    	double[] areaValue = new double[0];
    	double[] widthValue = new double[0];
    	
    	int widthPos = 0;
    	double[] dataArrayY = GRIPContourReport.getNumberArray("centerY", yValue);
    	double[] dataArrayX = GRIPContourReport.getNumberArray("centerX", xValue);
    	double[] dataArrayArea = GRIPContourReport.getNumberArray("area", areaValue);
    	double[] dataArrayWidth = GRIPContourReport.getNumberArray("width", widthValue);
    	//System.out.print(dataArrayX.length);
    	for(int i = 0; i < dataArrayWidth.length; i++){
    		if(dataArrayWidth[i] > dataArrayWidth[widthPos]){
    			widthPos = i;
    		}
    	}
    	//single double
        if (dataArrayY.length > widthPos) {	
    		centerYContour = dataArrayY[widthPos];
        }
    	//single double
        if (dataArrayX.length > widthPos){
        	centerXContour = dataArrayX[widthPos];
        }
        if (dataArrayX.length == 0) {
        	centerXContour = 0.0;
        }
        if (dataArrayArea.length > widthPos){
        	areaContour = dataArrayX[widthPos];
        }
        if (dataArrayArea.length == 0) {
        	areaContour = 0.0;
        }
        //System.out.print(Robot.centerXContour);
		//Showing the value of centerY on the smart dashboard
		//SmartDashboard.putNumber("The value of centerY is ", Robot.centerYContour);
		
		//Showing the value of centerX on the smart dashboard
		//SmartDashboard.putNumber("The value of centerX is ", Robot.centerXContour);
    }

}
