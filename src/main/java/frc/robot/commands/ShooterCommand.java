package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {
    private final ShooterSubsystem m_shooterSubsystem;

    public ShooterCommand(ShooterSubsystem shooterSubsystem) {
        this.m_shooterSubsystem = shooterSubsystem;
    }
    
    @Override
    public void execute() {
        // this will spit the ball out nicely if the ball color does not match alliance color
        if (Robot.getColorSensor().hasBall()) {
            if (Robot.getColorSensor().isRedBall() && DriverStation.getAlliance() != DriverStation.Alliance.Red
                || Robot.getColorSensor().isBlueBall() && DriverStation.getAlliance() != DriverStation.Alliance.Blue) {
                //todo drive motor slowly
                return;
            }
        }

        //todo drive motor
    }

     /**
     * @param interrupted
     */
    @Override
    public void end(boolean interrupted) {

    }
}
