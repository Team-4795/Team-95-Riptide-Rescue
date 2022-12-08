package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RomiDrivetrain;
import frc.robot.subsystems.Grabber;


public class AutonomousDrive extends SequentialCommandGroup{

    public AutonomousDrive(RomiDrivetrain drivetrain, Grabber grabber){
        addCommands(new Drive(1, 1, drivetrain));
        addCommands(new Turntime(1,1,drivetrain));
        addCommands(new Drive(1,1,drivetrain));
        addCommands(new Turntime(1,1,drivetrain));
        addCommands(new ArmTimed(grabber, 1, 1));
        addCommands(new GrabberTimed(grabber, 1, 1));
    }


}
