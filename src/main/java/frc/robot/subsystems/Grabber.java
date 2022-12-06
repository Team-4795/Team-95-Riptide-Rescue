package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;



public class Grabber extends SubsystemBase{
    //incorrect spark channels
    private PWMVictorSPX baseMotor = new PWMVictorSPX(2);
    private PWMVictorSPX grabberMotor = new PWMVictorSPX(8);
    //incorrect encoder channels, figure out later
    private Encoder baseEncoder = new Encoder(4,5);
    private Encoder grabberEncoder = new Encoder(6,7);
    //in degrees
    private final double minBaseAngle = 0;
    private final double maxBaseAngle = 90;
    private final double minGrabberAngle = -10;
    private final double maxGrabberAngle = 30;
    private final double countsPerRevolution = 1440.0;
    private double baseAngle = 0.0;
    private double grabberAngle = 0.0;
 
    public Grabber() {
        baseEncoder.reset();
        grabberEncoder.reset();
        baseMotor.setInverted(true);
        grabberMotor.setInverted(true);

    }

    public double getBaseAngle(){
        return (baseEncoder.get()*360/countsPerRevolution);
    }
 
    public double getGrabberAngle(){
        return (grabberEncoder.get()*360/countsPerRevolution);
    }
 
    public void baseMotorOn(double speed){
        baseAngle = this.getBaseAngle();
        if(baseAngle < maxBaseAngle && speed > 0){
            baseMotor.set(speed);
        }
        if(baseAngle > minBaseAngle && speed < 0){
            baseMotor.set(speed);
        }
        if(speed == 0){
            this.baseMotorOff();
        }
    }
 
    public void baseMotorOff(){
            baseMotor.stopMotor();
    }
 
    public void grabberMotorOn(double speed){
        grabberAngle = this.getGrabberAngle();
        if(grabberAngle<maxGrabberAngle && speed > 0){
            grabberMotor.set(speed);
        }
        if(grabberAngle>minGrabberAngle && speed < 0){
            // condition supposed to be grabberAngle>minGrabberAngle && speed < 0
            grabberMotor.set(speed);
        }
        if(speed == 0){
            this.grabberMotorOff();
        }
    }
 
    public void grabberMotorOff(){
            grabberMotor.stopMotor();
    }
 
    @Override
    public void initSendable(SendableBuilder builder) {
      builder.setSmartDashboardType("Vision");
      builder.addDoubleProperty("Grabber Encoder", () -> baseAngle, null);
    }
    @Override
    public void periodic(){ 


    }

}
