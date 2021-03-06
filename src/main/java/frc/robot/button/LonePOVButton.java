/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.button;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Add your docs here.
 */
public class LonePOVButton extends Trigger {

  POVButton include;
  JoystickButton exclude1;
  JoystickButton exclude2;

  public LonePOVButton(POVButton include, JoystickButton exclude1, JoystickButton exclude2) {

  }

  @Override
  public boolean get() {
    if(include.get() && !exclude1.get() && !exclude2.get()) {
      return true;
    }
    return false;
  }
}
