package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;
import org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants;

import java.util.logging.Level;

import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.CAP_BOTTOM_POS;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.CAP_HIGH_POS;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.CAP_MID_POS;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_DOWN_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_HIGH_POSITION;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_LOW_POSITION_AUTON;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_MID_POSITION_TELE;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_PID_COEFFICIENTS;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_TOLERANCE;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_RESTING_POSITION;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_MID_POSITION;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.LIFT_UP_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.DEL_CLOSE_POS;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.Lift.DEL_OPEN_POS;


@Config
/**
 * Lift class controls the scoring lift and ball/box depositer
 */
public class Cap extends SubsystemBase {
    private Telemetry telemetry;
    private ServoEx capServo;

    double CURRENT_CAP_POS = CAP_HIGH_POS;

    public Cap(HardwareMap hw, Telemetry tl) {
        this.capServo = new SimpleServo(hw, SubsystemConstants.Lift.CAP_SERVO_ID, 0, 1);
        this.telemetry = tl;
    }
    @Override
    public void periodic() {
        capServo.setPosition(CURRENT_CAP_POS);
    }

    public void toggleCap() {
        if(CURRENT_CAP_POS == CAP_HIGH_POS)
        {
            CURRENT_CAP_POS = CAP_BOTTOM_POS;
        } else
        {
            CURRENT_CAP_POS = CAP_HIGH_POS;
        }
    }

    public void capWithJoystick(double joystickPos) {

        CURRENT_CAP_POS = CURRENT_CAP_POS - (joystickPos);
        if(CURRENT_CAP_POS > CAP_HIGH_POS) {
            CURRENT_CAP_POS = CAP_HIGH_POS;
        }
        else if (CURRENT_CAP_POS < CAP_BOTTOM_POS) {
            CURRENT_CAP_POS = CAP_BOTTOM_POS;
        }
    }
/*
    public void scoreCap(){
        CURRENT_CAP_POS = CAP_MID_POS;
    }

 */
    /*
    public void capUpManual() {
        CURRENT_CAP_POS += 0.002;
    }
    public void capDownManual() {
        CURRENT_CAP_POS -= 0.002;
    }

     */
}

