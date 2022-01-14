/*

Subcommand called within GalacticSearch
Robot drives straight forward then stops after a certain distance is measured by encoders

*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveForward extends CommandBase {
  /** Creates a new DriveForward. */

  private double distance;
  private double distance_remaining;
  private double angle;
  private double encoder_pos;
  private double encoder_pos_prev;
  private double total_revs;

  public DriveForward(double distance, double angle) {

    this.distance = distance;
    this.angle = angle;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    RobotContainer.dt.zeroEncoders();
    total_revs = 0;
    encoder_pos = 0;
    distance_remaining = distance;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.dt.driveforward(angle, distance_remaining);
    encoder_pos_prev = encoder_pos;
    encoder_pos = RobotContainer.dt.getDistance();
    if (encoder_pos < encoder_pos_prev){

      total_revs++;
    }
    distance_remaining = distance - (total_revs + encoder_pos / 360) * Constants.ENCODER_SCALER; 
    System.out.println(distance_remaining);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    RobotContainer.dt.stopMoving();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return distance_remaining >= 0;
  }
}
