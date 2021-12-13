package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.LEFT_393_ID;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.RIGHT_393_ID;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.INTAKE_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.OUTTAKE_SPEED;

@Config
public class DuckWheels extends SubsystemBase {
    Telemetry telemetry;
    private CRServo left393;
    private CRServo right393;

    public DuckWheels(HardwareMap hw, Telemetry tl) {
        this.left393 = new CRServo(hw, LEFT_393_ID);
        this.right393 = new CRServo(hw, RIGHT_393_ID);
        right393.setInverted(true);
        left393.setInverted(false);

        this.telemetry = tl;
    }

    @Override
    public void periodic() {
        //Util.logger(this, telemetry, Level.INFO, "Current Intake Speed", intake.get());
    }
/*
    private void set(double speed) {
        left393.set(speed);
        right393.set(speed);
    }

 */

    public void spinDuckRed() {
        left393.set(INTAKE_SPEED);
    }
    public void spinDuckBlue() {
        right393.set(INTAKE_SPEED);
    }
    public void otherWayRed() {
        left393.set(OUTTAKE_SPEED);
    }
    public void otherWayBlue() {
        right393.set(OUTTAKE_SPEED);
    }

    public void spinBoth() {
        left393.set(INTAKE_SPEED);
        right393.set(INTAKE_SPEED);
    }
    public void otherWayBoth() {
        left393.set(OUTTAKE_SPEED);
        right393.set(OUTTAKE_SPEED);
    }    public void stop() {
        left393.stopMotor();
        right393.stopMotor();
    }

    public void spinHold() {
        left393.set(INTAKE_SPEED);
        right393.set(INTAKE_SPEED);
    }
}
