package org.firstinspires.ftc.teamcode.autons;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SelectCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.MatchOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.pipelines.TeamMarkerPipeline;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

import java.util.HashMap;

//@Disabled
@Autonomous(name = "TEST", group = "testing")
public class Test extends MatchOpMode {
    public static double startPoseX = 0;
    public static double startPoseY = 0;
    public static double startPoseHeading = 0;

    // Motors
    private MotorEx leftFront, leftRear, rightRear, rightFront;
    private MotorEx intakeMotor;

    // Gamepad
    private GamepadEx driverGamepad;

    // Subsystems
    private Drivetrain drivetrain;
    private Intake intake;
    private Lift lift;
    private DuckWheels duckWheels;


    @Override
    public void robotInit() {
        // Subsystems
        drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap), telemetry);
        drivetrain.init();

        intake = new Intake(hardwareMap, telemetry);
        lift = new Lift(hardwareMap,telemetry);
        duckWheels = new DuckWheels(hardwareMap,telemetry);

        //drivetrain.setPoseEstimate(Trajectories.BlueLeftTape.startPose);
        drivetrain.setPoseEstimate(new Pose2d(startPoseX, startPoseY, Math.toRadians(startPoseHeading)));
    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void matchStart() {
            schedule(new TestAutonCommand(drivetrain, intake, duckWheels, lift, telemetry)
        );

    }
}