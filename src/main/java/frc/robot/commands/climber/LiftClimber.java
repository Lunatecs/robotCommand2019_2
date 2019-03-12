/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftClimber extends Command {

  private boolean isFinished = false;
  private double climberSpeed = 0.0;

  public LiftClimber(double speed) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.climber);
    this.climberSpeed = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    this.isFinished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //------------------Climber------------------
    if (Robot.climber.getLimitSwitch() && Robot.climber.isPastRequiredDistance()) {
      Robot.climber.setLiftSpeed(0);
      isFinished = true;
    } else {
      Robot.climber.setLiftSpeed(this.climberSpeed);
      isFinished = false;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
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
