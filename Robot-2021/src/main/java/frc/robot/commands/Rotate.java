/*

Subsommand called within GalacticSearch
Robot rotates then stops after the gyroscope measures the desired angle

*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class Rotate extends CommandBase {
  /** Creates a new Rotate. 
   * Paramter: angle in decimal degrees, CCW is positive
  */

  private double angle;
  private double current_angle;

  public Rotate(double angle) {
    // Use addRequirements() here to declare subsystem dependencies.

    this.angle = angle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


    RobotContainer.dt.rotate(angle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    RobotContainer.dt.stopMoving();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(current_angle - angle) < Constants.angleThres;
  }
}
