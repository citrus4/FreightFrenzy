package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.AUTON_OPPOSITE_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.AUTON_SPIN_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.LEFT_393_ID;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.OPPOSITE_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.RIGHT_393_ID;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.SPIN_SPEED;

@Config
public class DuckWheels extends SubsystemBase {
    Telemetry telemetry;
    private CRServo left393;
    //private CRServo right393;

    public DuckWheels(HardwareMap hw, Telemetry tl) {
        this.left393 = new CRServo(hw, LEFT_393_ID);
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
        left393.set(SPIN_SPEED);
    }

    public void otherWayRed() {
        left393.set(OPPOSITE_SPEED);
    }


    public void spinBoth() {
        left393.set(SPIN_SPEED);
        //right393.set(SPIN_SPEED);
    }
    public void otherWayBoth() {
        left393.set(OPPOSITE_SPEED);
    }

    public void spinAuton() {
        left393.set(AUTON_SPIN_SPEED);
        //right393.set(SPIN_SPEED);
    }
    public void otherWayAuton() {
        left393.set(AUTON_OPPOSITE_SPEED);
    }

    public void stop() {
        left393.stopMotor();
    }

    public void spinHold() {
        left393.set(SPIN_SPEED);
    }
}
