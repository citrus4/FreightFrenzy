package org.firstinspires.ftc.teamcode.autons;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.IMUTurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class TestAutonCommand extends SequentialCommandGroup {
    public TestAutonCommand(Drivetrain drivetrain, Intake intake, DuckWheels duckWheels, Lift lift, Telemetry telemetry) {
        //declare variables here

        addCommands(
            //new TurnCommand(drivetrain, 30),
                //new TurnCommand(drivetrain, 30),
                //new TurnToCommand(drivetrain, 130, true),
                //new DriveForwardCommand(drivetrain, 50),
                //new StrafeSidewaysCommand(drivetrain, 50),
               // new SplineCommand(drivetrain, new Vector2d(5, 5), Math.toRadians(130), false),
                //new IMUTurnCommand(drivetrain, 130)

                //new SplineCommand(drivetrain, new Vector2d(10, 20), Math.toRadians(180), true)
                //new StrafeToCommand(drivetrain, new Pose2d(30, 20, Math.toRadians(88))),
                //new LineToHeadingCommand(drivetrain, new Pose2d(20, 20, Math.toRadians(45)))
                //new SplineConstantHeadingCommand(drivetrain, new Vector2d(20, 8), Math.toRadians(0))
                //new TurnCommand(drivetrain, -360)
                new SplineCommand(drivetrain, new Vector2d(5, 4), Math.toRadians(147), false),
                new IMUTurnCommand(drivetrain, 147),
                //cc
                new InstantCommand(duckWheels::spinBoth),
                new KindaSlowDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1500),
                new InstantCommand(duckWheels::stop),
                new DriveForwardCommand(drivetrain, -2),
                new IMUTurnCommand(drivetrain, 180),
                new SplineCommand(drivetrain, new Vector2d(17, -0), Math.toRadians(65), true),
                new WaitCommand(2000),
                new IMUTurnCommand(drivetrain, 65),
                new InstantCommand(lift::liftLow),
                new DriveForwardCommand(drivetrain, -3),//might need more
                new InstantCommand(lift::toggleDel),
                new DriveForwardCommand(drivetrain, 3),
                new SplineCommand(drivetrain, new Vector2d(6, 6), Math.toRadians(180), false)



                //park

        );
    }
}