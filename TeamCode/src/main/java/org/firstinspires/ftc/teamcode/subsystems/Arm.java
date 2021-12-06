package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;

import java.util.logging.Level;

import static org.firstinspires.ftc.teamcode.subsystems.SubsystemConstants.Arm.ARM_UP_POS;
import static org.firstinspires.ftc.teamcode.subsystems.SubsystemConstants.Arm.ARM_DOWN_POS;
import static org.firstinspires.ftc.teamcode.subsystems.SubsystemConstants.Arm.ARM_SCORE_POS;
import static org.firstinspires.ftc.teamcode.subsystems.SubsystemConstants.Arm.ARM_REST_POS;

@Config
/**
 * Lift class controls the scoring lift and ball/box depositer
 */
public class Arm extends SubsystemBase {
    private Telemetry telemetry;
    private ServoEx armServo;

    public Arm(HardwareMap hw, Telemetry tl) {
        this.armServo = new SimpleServo(hw, SubsystemConstants.Arm.ARM_SERVO_ID, 0,1);

        this.telemetry = tl;
    }
    @Override
    public void periodic() {
    }

    public void armUp() {
        armServo.setPosition(ARM_UP_POS);
    }

    public void armDown() {
        armServo.setPosition(ARM_DOWN_POS);
    }

    public void armScore() {
        armServo.setPosition(ARM_SCORE_POS);
    }

    public void armRest() {
        armServo.setPosition(ARM_REST_POS);
    }
}

