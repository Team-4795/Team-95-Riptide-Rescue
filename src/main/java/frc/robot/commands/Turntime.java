package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/*
 * Creates a new TurnTime command. This command will turn your robot for a
 * desired rotational speed and time.
 */
public class Turntime extends CommandBase {
  private final double m_duration;
  private final double m_rotationalSpeed;
  private final RomiDrivetrain m_drive;
  private long m_startTime;

  public Turntime(double speed, double time, RomiDrivetrain drive) {
    m_rotationalSpeed = speed;
    m_duration = time * 1000;
    m_drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
    m_drive.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(0, m_rotationalSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - m_startTime) >= m_duration;
  }
}
