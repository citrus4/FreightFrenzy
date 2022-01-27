package org.firstinspires.ftc.teamcode.autons;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.FastDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.IMUTurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.ReallySlowDriveCommand;
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
                //command sequence
                //duck
                new InstantCommand(lift::closeDel),
                new KindaSlowDriveForwardCommand(drivetrain, -12.4),
                new IMUTurnCommand(drivetrain, 90, true),
                new KindaSlowDriveForwardCommand(drivetrain, 30),
                new InstantCommand(duckWheels::spinAuton),
                new KindaSlowDriveForwardCommand(drivetrain, 3),
                new WaitCommand(4500),

                new InstantCommand(duckWheels::stop),
                new DriveForwardCommand(drivetrain, -5),
                new IMUTurnCommand(drivetrain, 0),

                //deliver pre-load
                //left(low)
                new SplineCommand(drivetrain, new Vector2d(56, 5.4), 85, true),
                new WaitCommand(200),

                //new IMUTurnCommand(drivetrain, 135, true),
                new IMUTurnCommand(drivetrain, -230, true),
                new InstantCommand(lift::liftLow),

                new SlowDriveForwardCommand(drivetrain, -12),
                new WaitCommand(200),

                new InstantCommand(lift::toggleDel),
                new SlowDriveForwardCommand(drivetrain, 8),
                new InstantCommand(lift::toggleDel),

                //park
                new IMUTurnCommand(drivetrain, 270, true),
                new SplineCommand(drivetrain,new Vector2d( 31, -25), 270, true)
        );
    }
}