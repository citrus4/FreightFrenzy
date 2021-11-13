package org.firstinspires.ftc.teamcode.autons.lm1.blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowestDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class BluePushCommand extends SequentialCommandGroup {
    public BluePushCommand(Drivetrain drivetrain, Intake intake, Telemetry telemetry) {
        //declare variables here

        addCommands(
                new InstantCommand(intake::halfIntakeBlue, intake),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1000),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1000),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1000),

                new InstantCommand(intake::stop, intake),
                new TurnCommand(drivetrain, -35),
                new KindaSlowDriveForwardCommand(drivetrain, -50),
                new TurnCommand(drivetrain, 42),
                new DriveForwardCommand(drivetrain, -100)
        );
    }
}