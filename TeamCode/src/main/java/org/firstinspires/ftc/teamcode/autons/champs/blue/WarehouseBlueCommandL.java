package org.firstinspires.ftc.teamcode.autons.champs.blue;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SplineCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class WarehouseBlueCommandL extends SequentialCommandGroup {
    public WarehouseBlueCommandL(Drivetrain drivetrain, Lift lift, Intake intake, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                new InstantCommand(lift::closeDel),
                new SplineCommand(drivetrain, new Vector2d(23.5,-20), Math.toRadians(0)),
                new InstantCommand(lift::liftLow),
                new SplineCommand(drivetrain, new Vector2d(-5,35), Math.toRadians(90)),

                new InstantCommand(intake::intake),
                new DriveForwardCommand(drivetrain,5),
                new WaitCommand(1000),
                new InstantCommand(intake::stop),

                new SplineCommand(drivetrain, new Vector2d(24.5,   -19), Math.toRadians(0), true),
                new InstantCommand(lift::liftLow),
                new InstantCommand(lift::openDel),
                new WaitCommand(700),
                new InstantCommand(lift::closeDel),

                new DriveForwardCommand(drivetrain, 2),
                new InstantCommand(lift::liftLow),
                new SplineCommand(drivetrain, new Vector2d(-5,35), Math.toRadians(90)),

                new InstantCommand(intake::intake),
                new DriveForwardCommand(drivetrain,7),
                new WaitCommand(1000),
                new InstantCommand(intake::stop),

                new SplineCommand(drivetrain, new Vector2d(24.5,   -19), Math.toRadians(0), true),
                new InstantCommand(lift::liftLow),
                new InstantCommand(lift::openDel),
                new WaitCommand(700),
                new InstantCommand(lift::closeDel),

                new DriveForwardCommand(drivetrain, 2),
                new InstantCommand(lift::liftLow),
                new SplineCommand(drivetrain, new Vector2d(-5,35), Math.toRadians(90)),

                new InstantCommand(intake::intake),
                new DriveForwardCommand(drivetrain,7),
                new WaitCommand(1000),
                new InstantCommand(intake::stop),

                new SplineCommand(drivetrain, new Vector2d(24.5,   -19), Math.toRadians(0), true),
                new InstantCommand(lift::liftLow),
                new InstantCommand(lift::openDel),
                new WaitCommand(700),
                new InstantCommand(lift::closeDel),

                new DriveForwardCommand(drivetrain, 2),
                new InstantCommand(lift::liftLow),
                new SplineCommand(drivetrain, new Vector2d(-5,35), Math.toRadians(90))
        );
    }
}
