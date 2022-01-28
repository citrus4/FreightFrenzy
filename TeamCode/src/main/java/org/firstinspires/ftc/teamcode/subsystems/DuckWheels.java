package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.AUTON_BLUE_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.AUTON_RED_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.BLUE_SPEED;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.DUCK_SERVO_ID;
import static org.firstinspires.ftc.teamcode.subsystems.constants.SubsystemConstants.DuckWheels.RED_SPEED;

@Config
public class DuckWheels extends SubsystemBase {
    Telemetry telemetry;
    private CRServo duckServo;

    public DuckWheels(HardwareMap hw, Telemetry tl) {
        this.duckServo = new CRServo(hw, DUCK_SERVO_ID);
        duckServo.setInverted(false);

        this.telemetry = tl;
    }

    @Override
    public void periodic() {
        //Util.logger(this, telemetry, Level.INFO, "Current Intake Speed", intake.get());
    }

    public void spinDuckBlue() {
        duckServo.set(BLUE_SPEED);
    }

    public void spinDuckRed() {
        duckServo.set(RED_SPEED);
    }


    public void spinBlueAuton() {
        duckServo.set(AUTON_BLUE_SPEED);
    }

    public void spinRedAuton() {
        duckServo.set(AUTON_RED_SPEED);
    }

    public void stop() {
        duckServo.stopMotor();
    }

    public void spinHold() {
        duckServo.set(RED_SPEED);
    }
}
