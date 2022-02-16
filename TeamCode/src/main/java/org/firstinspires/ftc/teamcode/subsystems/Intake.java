package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SensorDistanceEx;
import com.arcrobotics.ftclib.hardware.SensorRevTOFDistance;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREV2mDistance;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Util;

import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Intake.DISTANCE_SENSOR_ID;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Intake.INTAKE_MOTOR_ID;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Intake.INTAKE_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Intake.OUTTAKE_SPEED;

import java.util.logging.Level;

@Config
public class Intake extends SubsystemBase {
    Telemetry telemetry;
    private MotorEx intakeMotor;
    //private SensorRevTOFDistance distanceSensor;

    public Intake(HardwareMap hw, Telemetry tl) {
        this.intakeMotor = new MotorEx(hw, INTAKE_MOTOR_ID);
        //this.distanceSensor = new SensorRevTOFDistance(hw, DISTANCE_SENSOR_ID);
        intakeMotor.setInverted(true);

        this.telemetry = tl;
    }

    @Override
    public void periodic() {
        //Util.logger(this, telemetry, Level.INFO, "Current Intake Speed", intake.get());
        //Util.logger(this, telemetry, Level.INFO,"distance", distanceSensor.getDistance(DistanceUnit.MM));
    }

    private void set(double speed) {
        intakeMotor.set(speed);
    }

    public void intake() {
        set(INTAKE_SPEED);
    }

    public void outtake() {
        set(OUTTAKE_SPEED);
    }

    public void stop() {
        intakeMotor.stopMotor();
    }
/*
    public boolean isFreight() {
        return distanceSensor.targetReached(new SensorDistanceEx.DistanceTarget(DistanceUnit.MM, 10, 2));
    }
 */
}
