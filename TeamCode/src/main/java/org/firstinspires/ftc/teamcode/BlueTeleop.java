package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.drive.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveCommand;
import org.firstinspires.ftc.teamcode.drive.MatchOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@Config
@TeleOp(name = "BlueTeleOp")
public class BlueTeleop extends MatchOpMode {
    // Motors
    private MotorEx leftFront, leftCenter, leftRear, rightRear, rightCenter, rightFront;
    private MotorEx liftMotor;
    private MotorEx intakeMotor;

    // Gamepad
    private GamepadEx driverGamepad, operatorGamepad;

    // Subsystems
    private Drivetrain drivetrain;
    //private Lift lift;
    private Intake intake;

    //Buttons
    private Button intakeButton, halfSpeedButton, outtakeButton;
    private Button slowModeTrigger;
    public Button liftUpButton, liftDownButton;
    public Button liftRestButton, liftLowButton, liftMidButton, liftHighButton, liftCapButton;

    @Override
    public void robotInit() {

        // Intake hardware Initializations
        intakeMotor = new MotorEx(hardwareMap, "intakeMotor");
        // Lift hardware initializations
        //liftMotor = new MotorEx(hardwareMap, "lift");

        // Subsystems
        drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap),telemetry);
        drivetrain.init();
        intake = new Intake(intakeMotor, telemetry);
        //lift = new Lift(liftMotor, telemetry);

        //gamepad1.setJoystickDeadzone(0.0f);
        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);
        drivetrain.setDefaultCommand(new DefaultDriveCommand(drivetrain, driverGamepad));

    }

    @Override
    public void configureButtons() {

        slowModeTrigger = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER)).whileHeld(new SlowDriveCommand(drivetrain, driverGamepad));
        intakeButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.B).whileHeld(intake::intakeBlue).whenReleased(intake::stop));
        halfSpeedButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.RIGHT_BUMPER).whileHeld(intake::halfIntakeBlue).whenReleased(intake::stop));
        outtakeButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.LEFT_BUMPER).whileHeld(intake::intakeRed).whenReleased(intake::stop));
        //intakeButton = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.LEFT_TRIGGER)).whileHeld(intake::intake).whenReleased(intake::stop);
        //outtakeButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.X)).whileHeld(intake::outtake).whenReleased(intake::stop);

        //liftUpButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.RIGHT_BUMPER).whenPressed(lift::liftLow));
        //liftDownButton = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER).whenPressed(lift::liftResting));
        //liftRestButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_DOWN).whenPressed(lift::liftResting));
        //liftLowButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_LEFT).whenPressed(lift::liftLow));
        //liftMidButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_RIGHT).whenPressed(lift::liftMid));
        //liftHighButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_UP).whenPressed(lift::liftHigh));
        //liftCapButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.X).whenPressed(lift::liftCap));


/*
        singleFeedButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.Y)).whenPressed(new FeedRingsCommand(feeder, 1));
        // TRIPLE SHOT SPEED *********************
        tripleFeedButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.LEFT_BUMPER)).whenPressed(new SmartFeedRingsCommand(feeder, shooterWheels,4,30));
        shootButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.RIGHT_BUMPER)).toggleWhenPressed(
                new InstantCommand(() -> shooterWheels.setShooterRPM(ShooterWheels.TARGET_SPEED), shooterWheels),
                new InstantCommand(() -> shooterWheels.setShooterRPM(0), shooterWheels));
        (new GamepadButton(driverGamepad, GamepadKeys.Button.LEFT_STICK_BUTTON)).whileHeld(new VisionCommand(drivetrain, vision, 30));
        powershotButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.B)).toggleWhenPressed(
                new InstantCommand(() -> shooterWheels.setShooterRPM(2900), shooterWheels),
                new InstantCommand(() -> shooterWheels.setShooterRPM(0), shooterWheels));
        intakeButton = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.LEFT_TRIGGER)).whileHeld(intake::intake).whenReleased(intake::stop);
        outtakeButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.X)).whileHeld(intake::outtake).whenReleased(intake::stop);

        toggleClawButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.A)).toggleWhenPressed(
                new InstantCommand(wobbleGoalArm::openClaw, wobbleGoalArm),
                new InstantCommand(wobbleGoalArm::closeClaw, wobbleGoalArm)
        );

        liftArmButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_UP)).whenPressed(wobbleGoalArm::liftWobbleGoal);
        lowerArmButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_DOWN)).whenPressed(wobbleGoalArm::placeWobbleGoal);


        (new GamepadButton(driverGamepad, GamepadKeys.Button.BACK)).whenPressed(() -> shooterWheels.adjustShooterRPM(75));
        (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_LEFT)).whenPressed(() -> shooterWheels.adjustShooterRPM(-75));
        lowMidWobbleButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_RIGHT)).whenPressed(() -> wobbleGoalArm.setWobbleGoal(-65));
        (new GamepadButton(driverGamepad, GamepadKeys.Button.RIGHT_STICK_BUTTON)).toggleWhenPressed(new InstantCommand(intake::dropIntake, intake), new InstantCommand(intake::liftIntake, intake));
        drivetrain.setDefaultCommand(new DefaultDriveCommand(drivetrain, driverGamepad));
        (new GamepadButton(operatorGamepad, GamepadKeys.Button.Y)).whenPressed(wobbleGoalArm::liftArmManual).whenReleased(wobbleGoalArm::stopArm);
        (new GamepadButton(operatorGamepad, GamepadKeys.Button.X)).whenPressed(wobbleGoalArm::lowerArmManual).whenReleased(wobbleGoalArm::stopArm);
 */
        //drivetrain.setDefaultCommand(new DefaultDriveCommand(drivetrain, driverGamepad));
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void matchStart() {
    }

    @Override
    public void robotPeriodic() {
    }
}