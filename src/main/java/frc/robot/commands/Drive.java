package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class Drive extends CommandBase{
    private double m_speed;
    private double m_time;
    private double m_startTime;
    private RomiDrivetrain m_drivetrain;


    public Drive(double speed, double time, RomiDrivetrain drivetrain){
        m_speed = speed;
        m_time = time*1000;
        m_drivetrain = drivetrain;
        addRequirements(drivetrain);
    }
    @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - m_startTime) >= m_time;
  }
}

