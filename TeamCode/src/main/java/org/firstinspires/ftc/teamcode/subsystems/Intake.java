package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static org.firstinspires.ftc.teamcode.subsystems.SubsystemConstants.Intake.INTAKE_MOTOR_ID;
import static org.firstinspires.ftc.teamcode.subsystems.SubsystemConstants.Intake.INTAKE_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.SubsystemConstants.Intake.OUTTAKE_SPEED;

@Config
public class Intake extends SubsystemBase {
    Telemetry telemetry;
    private MotorEx intakeMotor;

    public Intake(HardwareMap hw, Telemetry tl) {
        this.intakeMotor = new MotorEx(hw, INTAKE_MOTOR_ID);
        intakeMotor.setInverted(true);

        this.telemetry = tl;
    }

    @Override
    public void periodic() {
        //Util.logger(this, telemetry, Level.INFO, "Current Intake Speed", intake.get());
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
}
