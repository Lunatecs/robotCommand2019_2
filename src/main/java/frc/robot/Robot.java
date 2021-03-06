/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.autos.AutoDoNothing;
import frc.robot.commands.autos.AutoHatchStart;
import frc.robot.subsystems.CargoIntake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ElevatorSensors;
import frc.robot.subsystems.HatchIntake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.UltrasonicSensors;
import frc.robot.subsystems.Wench;
import frc.robot.subsystems.Suction;
import frc.robot.subsystems.LED;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;
  public static DriveTrain drive;
  public static Elevator elevator;
  public static CargoIntake cargoIntake;
  public static HatchIntake hatchIntake;
  public static LED led;
  public static Limelight limelight;
  public static ElevatorSensors elevatorSensors;
  public static UltrasonicSensors ultrasonicSensors;
  public static Climber climber;
  public static Wench wench;
  public static Suction suction;

  Command m_autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {   
    drive = new DriveTrain();
    elevator = new Elevator();
    cargoIntake = new CargoIntake();
    hatchIntake = new HatchIntake();
    led = new LED();
    limelight = new Limelight();
    elevatorSensors = new ElevatorSensors();
    ultrasonicSensors = new UltrasonicSensors();
    climber = new Climber();
    wench = new Wench();
    suction = new Suction();
    oi = new OI();

    SmartDashboard.putData(drive);
    // chooser.addOption("My Auto", new MyAutoCommand());
    chooser.addOption("None",new AutoDoNothing());
    chooser.addOption("Grab Hatch", new AutoHatchStart());
    SmartDashboard.putData("Auto mode", chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putBoolean("isRaised", Robot.climber.isLowerd);
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    SmartDashboard.putBoolean("AUTO FINISHED", false);
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = chooser.getSelected();
    if(m_autonomousCommand != null && this.m_autonomousCommand instanceof AutoHatchStart) {
      m_autonomousCommand.start();
    }

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    led.countDownColorsInQueue();


  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {

  }
}
