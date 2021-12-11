package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.commands.drive.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.ReallySlowDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveCommand;
import org.firstinspires.ftc.teamcode.drive.MatchOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

@Config
@TeleOp(name = "Blue TeleOp", group = "kyle")
public class TeleBlue extends MatchOpMode {
    // Gamepad
    private GamepadEx driverGamepad, operatorGamepad;

    // Subsystems
    private Drivetrain drivetrain;
    private Lift lift;
    private Intake intake;
    private DuckWheels duckWheels;

    //Buttons
    private Button intakeButton, outtakeButton;
    private Button slowModeTrigger, reallySlowModeTrigger;
    public Button liftUpButton, liftDownButton, liftRestButton, liftHighButton;
    public Button deliveryButton;
    public Button spinButton, otherWay;


    @Override
    public void robotInit() {
        // Subsystems
        drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap),telemetry);
        drivetrain.init();
        intake = new Intake(hardwareMap, telemetry);
        lift = new Lift(hardwareMap, telemetry);
        duckWheels = new DuckWheels(hardwareMap, telemetry);

        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);
        drivetrain.setDefaultCommand(new DefaultDriveCommand(drivetrain, driverGamepad));
    }

    @Override
    public void configureButtons() {
        slowModeTrigger = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.LEFT_TRIGGER)).whileHeld(new SlowDriveCommand(drivetrain, driverGamepad));
        reallySlowModeTrigger = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER)).whileHeld(new ReallySlowDriveCommand(drivetrain, driverGamepad));

        intakeButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.RIGHT_BUMPER).whileHeld(intake::intake).whenReleased(intake::stop));
        outtakeButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.LEFT_BUMPER).whileHeld(intake::outtake).whenReleased(intake::stop));

        liftUpButton = (new GamepadTrigger(operatorGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER).whenPressed(lift::moveUp));
        liftDownButton = (new GamepadTrigger(operatorGamepad, GamepadKeys.Trigger.LEFT_TRIGGER).whenPressed(lift::moveDown));
        liftRestButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.LEFT_BUMPER).whenPressed(new LowerLiftCommand(lift)));
        liftHighButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.RIGHT_BUMPER).whenPressed(lift::liftHigh));

        deliveryButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.A)).toggleWhenPressed(
                new InstantCommand(lift::toggleOpen, lift),
                new InstantCommand(lift::toggleClosed, lift)
        );

        spinButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_UP)).toggleWhenPressed(
                new InstantCommand(duckWheels::spinDuckBlue, duckWheels),
                new InstantCommand(duckWheels::stop, duckWheels)
        );
        spinButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_DOWN)).toggleWhenPressed(
                new InstantCommand(duckWheels::otherWayBlue, duckWheels),
                new InstantCommand(duckWheels::stop, duckWheels)
        );
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void matchStart() {
        lift.liftLow();
        //lift.closeDelivery();
    }

    @Override
    public void robotPeriodic() {
    }
}
