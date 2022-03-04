package org.firstinspires.ftc.teamcode.autons.regionals.red.warehouse;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.auton.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TwoSplineCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class RedRegionals2CycleCommandSequence extends SequentialCommandGroup {
    public RedRegionals2CycleCommandSequence(Drivetrain drivetrain, Lift lift, Intake intake, Telemetry telemetry) {
        addCommands(
                //begin sequence

                new InstantCommand(intake::intake),

                new TwoSplineCommand(drivetrain, new Vector2d(-3, -3), new Vector2d(-3, -40.0), -265.8, -264.5),
                new WaitCommand(50),
                new TurnToCommand(drivetrain, 270, false),
                new InstantCommand(intake::outtake),
                new TwoSplineCommand(drivetrain, new Vector2d(-4,10), new Vector2d(16.5,19.5), -150, -220, true),
                new InstantCommand(intake::stop),
                new InstantCommand(lift::liftHigh),
                new TurnToCommand(drivetrain, 180, true),
                new InstantCommand(lift::openDel),
                new DriveForwardCommand(drivetrain, 4),
                new InstantCommand(lift::closeDel),
                new InstantCommand(lift::liftLow),
                new InstantCommand(intake::intake),

                new TwoSplineCommand(drivetrain, new Vector2d(-3, -4), new Vector2d(-3, -40.0), -265.8, -264.5),
                new WaitCommand(50),
                new TurnToCommand(drivetrain, 270, false),
                new InstantCommand(intake::outtake),
                new TwoSplineCommand(drivetrain, new Vector2d(-4,10), new Vector2d(15,19.5), -150, -220, true),
                new InstantCommand(lift::liftHigh),
                new TurnToCommand(drivetrain, 180, true),
                new InstantCommand(lift::openDel),
                new DriveForwardCommand(drivetrain, 4),
                new InstantCommand(lift::closeDel),
                new InstantCommand(lift::liftLow),
                new InstantCommand(intake::intake)
        );
    }
}