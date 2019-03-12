/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.climber.DriveClimberWheels;
import frc.robot.commands.climber.LiftRobotAuto;
import frc.robot.commands.elevator.ElevatorWithSetPoint;
import frc.robot.commands.climber.DropArms;
import frc.robot.commands.climber.LiftClimber;

public class HabThreeClimb extends CommandGroup {
  /**
   * Add your docs here.
   */
  public HabThreeClimb() {

    //addSequential(new DropArms());
    addSequential(new LiftRobotAuto(.25));
    addSequential(new DriveClimberWheels(0.25,0.25, 20.0));
    addSequential(new ElevatorWithSetPoint(-2000, true));
    addSequential(new LiftClimber(.25));
    addSequential(new AutoForwardDrive(6.0, .25));

    //Lift Robot auto combines elevator and climber wheels
    //TODO ADD VALUES TO GROUP

    
    // A command group will require all of the subsystems that each member
    // would require.
  }
}
