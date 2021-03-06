/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
import frc.robot.commands.climber.DefaultWench;

public class Wench extends Subsystem {

  private WPI_VictorSPX wench_V = new WPI_VictorSPX(RobotMap.WENCH_VICTOR_ID);
  //public DoubleSolenoid suctionArm = new DoubleSolenoid(RobotMap.CLARMS_FORWARD_ID, RobotMap.CLARMS_BACKWARD_ID);

  private static NeutralMode WENCH_NEUTRAL_MODE = NeutralMode.Brake;
  
  public Wench() {
    wench_V.configFactoryDefault();
    wench_V.setNeutralMode(WENCH_NEUTRAL_MODE);
  }

  public void setWenchSpeed(double speed){
    wench_V.set(ControlMode.PercentOutput, speed);
  }

  public void realeaseClimber(){
    //suctionArm.set(DoubleSolenoid.Value.kReverse);
  }

  public void secureClimber(){
    //suctionArm.set(DoubleSolenoid.Value.kForward);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DefaultWench());
  }
}
