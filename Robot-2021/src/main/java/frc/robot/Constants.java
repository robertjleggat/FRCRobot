/*

Various values that are used in other areas of the code,
Consolidated to one class for easier adjustments

*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // distance (in decimal feet) followed by angle with horizontal (in degrees, cw is positive) for each leg of galactic search
    public static double[][] RedA = {{5, 0}, {5.59, 26.565}, {7.906, -71.565}, {12.5, 0}};
    public static double[][] BlueA = {{12.5, 0}, {7.906, -71.565}, {5.59, 26.565}, {5, 0}};
    public static double[][] RedB = {{5, 0}, {7.071, 45}, {7.071, -45}, {10, 0}};
    public static double[][] BlueB = {{12.5, 0}, {7.071, -45}, {7.071, 45}, {2.5, 0}};
    public static double[][] Calibration = {{30, 0}, {0,0}, {0,0}, {0,0}};


    public static double rotationSpeed = 0.4;   // autonomous max rotating speed, value between 0 and 1
    public static double driveSpeed = 0.4;    // autonomous max driving speed, value between 0 and 1
    public static double ROTATION_CORRECTION = 1/180;  // scaler on how aggressively to correct rotation when driving straight, no particular range
    public static double BRAKING_ZONE = 1; // remaining distance at which to begin tapering down driving speed, in feet
    public static double ANGULAR_BRAKING_ZONE = 45; // remaining angular distance at which to begin tapering down rotation speed, in degrees

    public static double angleThres = 1;   // allowed epsilon of error for autonomous rotation, in degrees
    public static double ENCODER_SCALER = 0.051051;  // to calibrate: multiply value by (actual distance traveled) / (target distance)  TUNE THIS!!!
    public static double INTAKE_TIME = 1.0; // time for intake motor to run, in seconds

    public static double ROTATION_SCALER = 0.6;  // teleop roation sensitivity, value between 0 (less sensitive) and 1 (more sensitive)
}
