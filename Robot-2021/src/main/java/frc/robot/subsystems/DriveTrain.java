/*

Defines various methods to more easily control the motor controllers, encoders, and gyroscope;
Backend methods that are used in the commands.

*/


package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.sensors.CANCoder;

public class DriveTrain extends SubsystemBase {


  private final WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(0);
  private final WPI_TalonSRX m_rearLeft = new WPI_TalonSRX(1);
  private final WPI_TalonSRX m_frontRight = new WPI_TalonSRX(2);
  private final WPI_TalonSRX m_rearRight = new WPI_TalonSRX(3);

  private final SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  private final SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  private final DifferentialDrive RobotDrive = new DifferentialDrive(m_left, m_right);

  public final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  private final CANCoder l_canCoder = new CANCoder(4);
  private final CANCoder r_canCoder = new CANCoder(5);

  public DriveTrain() {

  }

  public void calibrateGyro(){

    gyro.calibrate();
  }

  public void rotate(double angle){
    /**
     * 
     */
    
    double angle_remaining = gyro.getAngle() - angle;
    if (angle_remaining >= Constants.ANGULAR_BRAKING_ZONE){

      RobotDrive.arcadeDrive(0, -angle_remaining * Constants.rotationSpeed);
    } else {

      RobotDrive.arcadeDrive(0, Constants.rotationSpeed * (angle_remaining / Constants.ANGULAR_BRAKING_ZONE));
    }
  }

  public void driveforward(double angle, double distance_remaining){

    double error = gyro.getAngle() - angle;
    if (distance_remaining >= Constants.BRAKING_ZONE){

      RobotDrive.arcadeDrive(Constants.driveSpeed, -error * Constants.ROTATION_CORRECTION);
    } else{

      RobotDrive.arcadeDrive(Constants.driveSpeed * (distance_remaining / Constants.BRAKING_ZONE), -error * Constants.ROTATION_CORRECTION);
    }
  }

  public void stopMoving(){

    RobotDrive.arcadeDrive(0, 0);
  }

  public void startIntake(){

    System.out.println("intake machine go brrrrr");
    // integrate intake here when ready
  }

  public void stopIntake(){

    System.out.println("intake machine go Zzz");
  }

  public void zeroGyro(){

    gyro.reset();
  }

  public double getAngle(){

    return gyro.getAngle();
  }

  public void zeroEncoders(){
    
    l_canCoder.setPosition(0);
    r_canCoder.setPosition(0);
  }

  public double getDistance(){
    /**
     * Distance is in decimal feet.
     */
    return l_canCoder.getPosition();
  }

  public void arcadeDrive(double x, double y) {
    y = y * Constants.ROTATION_SCALER;
    //x = x * -1;//adds y axis
    RobotDrive.arcadeDrive(x, y);
    //System.out.println("uninverted");
  }
  public void inverseDrive(double x, double y){
    y = y * Constants.ROTATION_SCALER;//x axis
    //x = x * 1;//y axis
    RobotDrive.arcadeDrive(-x, y);
    //System.out.println("inverted");
  }

  @Override
  public void periodic(){

  }
}
