package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


public class Grabber extends SubsystemBase{
    //incorrect spark channels
    private Spark baseMotor = new Spark(2);
    private Spark grabberMotor = new Spark(3);
    //incorrect encoder channels, figure out later
    private Encoder baseEncoder = new Encoder(0,1);
    private Encoder grabberEncoder = new Encoder(2,3);
    //in degrees
    private final double minBaseAngle = 0;
    private final double maxBaseAngle = 170;
    private final double minGrabberAngle = 0;
    private final double maxGrabberAngle = 60;
    private final double countsPerRevolution = 1440.0;
    private double baseAngle = 0.0;
    private double grabberAngle = 0.0;
 
    public Grabber() {
        baseEncoder.reset();
        grabberEncoder.reset();

    }

    public double getBaseAngle(){
        return (baseEncoder.get()*2*Math.PI/countsPerRevolution);
    }
 
    public double getGrabberAngle(){
        return (grabberEncoder.get()*2*Math.PI/countsPerRevolution);
    }
 
    public void baseMotorOn(double speed){
        baseAngle = getBaseAngle();
        if(baseAngle<maxBaseAngle && speed > 0){
            baseMotor.set(speed);
        }
        if(baseAngle>minBaseAngle && speed < 0){
            baseMotor.set(speed);
        }
    }
 
    public void baseMotorOff(){
            baseMotor.stopMotor();
    }
 
    public void grabberMotorOn(double speed){
        grabberAngle = getGrabberAngle();
        if(grabberAngle<maxGrabberAngle && speed > 0){
            grabberMotor.set(speed);
        }
        if(grabberAngle>minGrabberAngle && speed < 0){
            grabberMotor.set(speed);
        }
    }
 
    public void grabberMotorOff(){
            grabberMotor.stopMotor();
    }
 
    @Override
    public void periodic(){ 


    }

}
