/*

Used to collect balls by running the intake motor for a given amount of time

*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class CollectBall extends CommandBase {

  Timer timer = new Timer();
  /** Creates a new CollectBall. */
  public CollectBall() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    RobotContainer.dt.startIntake();
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    RobotContainer.dt.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >= Constants.INTAKE_TIME;
  }
}
