/*

Assigns the joystick axis to driving the robot

*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
public class Teleop extends CommandBase {
private boolean driveInv = false;
  /**
   * Creates a new DriveTrainCommand.
   */
  public Teleop() {
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
  // Called every time the scheduler runs while the command is scheduled.


  @Override
  public void execute() {

    if (RobotContainer.j.getRawButtonPressed(2)) {
      driveInv = !driveInv;
      System.out.println("Inversion switched");
    }

    if (driveInv) {
      RobotContainer.dt.inverseDrive(RobotContainer.j.getY(), RobotContainer.j.getX());
    } else {
      RobotContainer.dt.arcadeDrive(RobotContainer.j.getY(), RobotContainer.j.getX());
    }

    System.out.println(RobotContainer.dt.getAngle());
  }

  @Override
  public boolean isFinished(){

    return false;
  }
}
