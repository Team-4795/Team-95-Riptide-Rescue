package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RomiDrivetrain;


public class AutonomousDrive extends SequentialCommandGroup{

    public AutonomousDrive(RomiDrivetrain drivetrain){
        addCommands(
            new Drive(1.0, 2.0, drivetrain)
            new Turntime(1, 2, drivetrain)
        );  
    }


}
