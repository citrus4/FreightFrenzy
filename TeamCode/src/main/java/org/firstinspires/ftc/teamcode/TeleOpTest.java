package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.commands.drive.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveCommand;
import org.firstinspires.ftc.teamcode.drive.MatchOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@Config
@TeleOp(name = "Teleop 1")
public class TeleOpTest extends MatchOpMode {
    // Motors
    private MotorEx leftFront, leftCenter, leftRear, rightRear, rightCenter, rightFront;
    private MotorEx liftMotor;
    private MotorEx intakeMotor;
    private ServoEx deliveryServo;

    // Gamepad
    private GamepadEx driverGamepad, operatorGamepad;

    // Subsystems
    private Drivetrain drivetrain;
    private Lift lift;
    private Intake intake;

    //Buttons
    private Button intakeButton, outtakeButton;
    private Button slowModeTrigger;
    public Button liftUpButton, liftDownButton, liftRestButton, liftHighButton;
    public Button openDeliveryButton, closeDeliveryButton;

    @Override
    public void robotInit() {

        // Intake hardware Initializations
        intakeMotor = new MotorEx(hardwareMap, "intake");
        // Lift hardware initializations
        liftMotor = new MotorEx(hardwareMap, "lift");
        deliveryServo = new SimpleServo(hardwareMap, "delivery", 0, 1);

        // Subsystems
        drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap),telemetry);
        drivetrain.init();
        intake = new Intake(intakeMotor, telemetry);
        lift = new Lift(liftMotor, deliveryServo, telemetry);

        //gamepad1.setJoystickDeadzone(0.0f);
        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);
        drivetrain.setDefaultCommand(new DefaultDriveCommand(drivetrain, driverGamepad));
    }

    @Override
    public void configureButtons() {

        slowModeTrigger = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.LEFT_TRIGGER)).whileHeld(new SlowDriveCommand(drivetrain, driverGamepad));

        intakeButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.RIGHT_BUMPER).whileHeld(intake::intake).whenReleased(intake::stop));
        outtakeButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.LEFT_BUMPER).whileHeld(intake::outtake).whenReleased(intake::stop));

        liftUpButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_UP).whenPressed(lift::moveUp));
        liftDownButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_DOWN).whenPressed(lift::moveDown));
        liftRestButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.Y).whenPressed(lift::liftResting));


        openDeliveryButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.RIGHT_BUMPER).whenPressed(lift::openDelivery));
        closeDeliveryButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.LEFT_BUMPER).whenPressed(lift::closeDelivery));

        //drivetrain.setDefaultCommand(new DefaultDriveCommand(drivetrain, driverGamepad));
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void matchStart() {
        lift.liftResting();
        lift.closeDelivery();
    }

    @Override
    public void robotPeriodic() {
    }
}
