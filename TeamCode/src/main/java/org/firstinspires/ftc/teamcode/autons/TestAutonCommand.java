package org.firstinspires.ftc.teamcode.autons;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.FastDriveCommand;
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
                new InstantCommand(lift::closeDel),
                new DriveForwardCommand(drivetrain, 24),
                new TurnToCommand(drivetrain,40, true),
                new DriveForwardCommand(drivetrain,15),
                new InstantCommand(lift::liftHigh),
                new WaitCommand(1000),
                new InstantCommand(lift::openDel),
                new WaitCommand(1000),

                //carasoul
                new InstantCommand(lift::liftLow),

                new InstantCommand(lift::closeDel),
                new DriveForwardCommand(drivetrain, -45),

                new KindaSlowDriveForwardCommand(drivetrain, -3),
                new InstantCommand(duckWheels::spinDuckRed),
                new WaitCommand(5000),
                new InstantCommand(duckWheels::stop),

                new TurnToCommand(drivetrain, 0),
                new DriveForwardCommand(drivetrain, 24),
                new TurnToCommand(drivetrain, -90,true),
                new DriveForwardCommand(drivetrain, 5)

        );
    }
}