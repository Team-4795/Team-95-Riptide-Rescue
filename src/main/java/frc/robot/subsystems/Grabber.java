package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;



public class Grabber extends SubsystemBase{
    private PWMVictorSPX baseMotor = new PWMVictorSPX(3);
    private PWMVictorSPX grabberMotor = new PWMVictorSPX(5);
    /*incorrect encoder channels, figure out later
    private Encoder baseEncoder = new Encoder(4,5);
    private Encoder grabberEncoder = new Encoder(6,7);
    private final double minBaseAngle = 0;
    private final double maxBaseAngle = 90;
    private final double minGrabberAngle = -10;
    private final double maxGrabberAngle = 30;
    private final double countsPerRevolution = 1440.0;
    private double baseAngle = 0.0;
    private double grabberAngle = 0.0;
    */
 
    public Grabber() {
        grabberMotor.setInverted(true);
    }

    /* public double getBaseAngle(){
        return (baseEncoder.get()*360/countsPerRevolution);
    }
 
    public double getGrabberAngle(){
        return (grabberEncoder.get()*360/countsPerRevolution);
    } */
 
    public void baseMotorOn(double speed){
        baseMotor.set(speed);
        if(speed == 0){
            this.baseMotorOff();
        }
        /*baseAngle = this.getBaseAngle();
        if(baseAngle < maxBaseAngle && speed > 0){
            baseMotor.set(speed);
        }
        if(baseAngle > minBaseAngle && speed < 0){
            baseMotor.set(speed);
        }
        if(speed == 0){
            this.baseMotorOff();
        }*/
    }
 
    public void baseMotorOff(){
            baseMotor.stopMotor();
    }
 
    public void grabberMotorOn(double speed){
        grabberMotor.set(speed);
        if(speed == 0){
            this.grabberMotorOff();
        }
        /*grabberAngle = this.getGrabberAngle();
        if(grabberAngle<maxGrabberAngle && speed > 0){
            grabberMotor.set(speed);
        }
        if(grabberAngle>minGrabberAngle && speed < 0){
            grabberMotor.set(speed);
        }
        if(speed == 0){
            this.grabberMotorOff();
        }*/
    }
 
    public void grabberMotorOff(){
        grabberMotor.stopMotor();
    }
 
    @Override
    public void periodic(){ 

    }

}
