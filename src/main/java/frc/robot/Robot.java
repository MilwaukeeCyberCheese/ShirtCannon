// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private final PWMSparkMax m_leftMotorFront = new PWMSparkMax(1);
  private final PWMSparkMax m_rightMotorFront = new PWMSparkMax(2);
  private final PWMSparkMax m_leftMotorBack = new PWMSparkMax(3);
  private final PWMSparkMax m_rightMotorBack = new PWMSparkMax(4);

  private final DoubleSolenoid NAME = new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 2);
  private final DoubleSolenoid NAMEII = new DoubleSolenoid(PneumaticsModuleType.REVPH, 3, 4);

  private final MotorControllerGroup m_left = new MotorControllerGroup(m_leftMotorFront, m_leftMotorBack);
  private final MotorControllerGroup m_right = new MotorControllerGroup(m_rightMotorFront, m_rightMotorBack);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);
  private final Joystick m_stick = new Joystick(0);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //TODO
   m_right.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_robotDrive.arcadeDrive(-m_stick.getY(), m_stick.getX());

    
  }
}