// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.GrabberCommand;
import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();

  private final Grabber m_grabber = new Grabber();

  final XboxController controller = new XboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings 
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_romiDrivetrain.setDefaultCommand(getArcadeDriveCommand());
    
    

    JoystickButton xButton = new JoystickButton(controller, XboxController.Button.kX.value);
    JoystickButton yButton = new JoystickButton(controller, XboxController.Button.kY.value);
    JoystickButton aButton = new JoystickButton(controller, XboxController.Button.kA.value);
    JoystickButton bButton = new JoystickButton(controller, XboxController.Button.kB.value);
 
    xButton.whenPressed(new ArmCommand(m_grabber, 0.2));
    xButton.whenReleased(new ArmCommand(m_grabber,0.0));
  
    yButton.whenPressed(new ArmCommand(m_grabber,-0.2));
    yButton.whenReleased(new ArmCommand(m_grabber, 0.0));
   
    aButton.whenPressed(new GrabberCommand(m_grabber, 0.2));
    aButton.whenReleased(new GrabberCommand(m_grabber, 0.0));

    bButton.whenPressed(new GrabberCommand(m_grabber, -0.2));
    bButton.whenReleased(new GrabberCommand(m_grabber, 0.0));
  }

  private Command getArcadeDriveCommand() {
    return new ArcadeDrive(
      m_romiDrivetrain, () -> -controller.getRawAxis(1), () -> controller.getRawAxis(4));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(){
    // An ExampleCommand will run in autonomous
    //it's null atm bc I feel like it
    return null;
  }
}
