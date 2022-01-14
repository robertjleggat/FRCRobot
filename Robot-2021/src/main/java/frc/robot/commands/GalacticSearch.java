/*

Sequentially calls all of the commands needed to complete the Galactic Search Challenge

*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GalacticSearch extends SequentialCommandGroup {
  /** Creates a new GalacticSearch. */
  private double[][] path;

  public GalacticSearch(double[][] path) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    this.path = path;

    for(int i=0; i<3; i++){

      addCommands(new DriveForward(this.path[i][0], this.path[i][1]), new CollectBall(), new Rotate(this.path[i+1][1]));
    }
    addCommands(new DriveForward(this.path[3][0] + Constants.BRAKING_ZONE, this.path[3][1]));  // ensures that the robot doesn't start braking until crossing the finish line

  }
}
