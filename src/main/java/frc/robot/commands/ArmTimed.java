package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grabber;

public class ArmTimed extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Grabber m_subsystem;
    private double m_time;
    private double m_speed;
    private double m_startTime;
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ArmTimed(Grabber subsystem, double time, double speed) {
      m_subsystem = subsystem;
      m_time = time*1000;
      m_speed = speed;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_startTime = System.currentTimeMillis();
    }
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_subsystem.baseMotorOn(m_speed);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_subsystem.baseMotorOff();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - m_startTime) >= m_time;
    } 
}
