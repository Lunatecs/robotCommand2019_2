/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ElevatorWithJoystick extends Command {

  static final double MIN_CLIMB_SPEED = .25;

  public ElevatorWithJoystick() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if(Robot.oi.operatorJoystick.getRawButton(RobotMap.RIGHT_BUMPER_ID)) {
      Robot.elevator.setSpeed(Robot.oi.getElevatorSpeed(), MIN_CLIMB_SPEED);
    } else {
      Robot.elevator.setSpeed(Robot.oi.getElevatorSpeed());
    }
    SmartDashboard.putData(Robot.elevator);
    SmartDashboard.putNumber("Encoder", Robot.elevator.getHeight());

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

}
