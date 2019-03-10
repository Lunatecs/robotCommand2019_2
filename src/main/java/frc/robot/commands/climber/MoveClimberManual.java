/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


//Allows for full control over climber for up and down. Used to test limit switches etc.
public class MoveClimberManual extends Command {

  private double climberSpeed = 0.0;

  public MoveClimberManual() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
        //------------------Climber------------------
    //TODO check if negative is down and positive is up on climber or swap

    //If toplimit and trying to go up(positive), stop from going up
    if(Robot.climber.getLimitSwitchTop() && this.climberSpeed > 0) {

      //TODO needs a minimum lift speed to keep us up(fighting springs)
      Robot.climber.setLiftSpeed(0); 

    //If bottomlimit of trying to go down(negative), stop from going down
    } else if(Robot.climber.getLimitSwitchBottom() && this.climberSpeed < 0) {

      Robot.climber.setLiftSpeed(0); 
    
    //Otherwise set speed to passed in speed
    } else {
      Robot.climber.setLiftSpeed(this.climberSpeed);
    }
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
