/*

This class is used to select which autonomous command to run through another GUI program called SmartDashboard

*/


package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static final DriveTrain dt = new DriveTrain();
  public static final Command teleop = new Teleop();
  public static final Command RedA = new GalacticSearch(Constants.RedA);
  public static final Command BlueA = new GalacticSearch(Constants.BlueA);
  public static final Command RedB = new GalacticSearch(Constants.RedB);
  public static final Command BlueB = new GalacticSearch(Constants.BlueB);
  public static final Command Calibrate = new GalacticSearch(Constants.Calibration);
  public static final Command autoNav = new AutoNav();

  SendableChooser<Command> chooser = new SendableChooser<>();


  
  public static final Joystick j = new Joystick(0);
  //private final Joystick oj = new Joystick(1);
  /*
  private JoystickButton positionalControlButton = new JoystickButton(oj, 3);
  private JoystickButton rotationalControlButton = new JoystickButton(oj, 5);
  */
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set up SmartDashboard stuff
    chooser.setDefaultOption("Teleop", teleop);
    chooser.addOption("RedA", RedA);
    chooser.addOption("BlueA", BlueA);
    chooser.addOption("RedB", RedB);
    chooser.addOption("BlueB", BlueB);
    chooser.addOption("AutoNav", autoNav);
    chooser.addOption("Calibrate", Calibrate);
    SmartDashboard.putData(chooser);
    
  }


  
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /*
    positionalControlButton.whenPressed(new PositionalControl());
    rotationalControlButton.whenHeld(new RotationalControl());
    */
  }

  


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // returns command selected in SmartDashboard
    return chooser.getSelected();
  }
}