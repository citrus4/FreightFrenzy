package org.firstinspires.ftc.teamcode.autons.lm1.red;

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

public class RedSafeCommand extends SequentialCommandGroup {
    public RedSafeCommand(Drivetrain drivetrain, Intake intake, Telemetry telemetry) {
        //declare variables here

        addCommands(
                new DriveForwardCommand(drivetrain, 45),
                new TurnToCommand(drivetrain, 141),
                new KindaSlowDriveForwardCommand(drivetrain, 38),
                new SlowDriveForwardCommand(drivetrain, 10),
                new InstantCommand(intake::halfIntakeRed, intake),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1200),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1200),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1200),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(800),
                new InstantCommand(intake::stop, intake),
                new DriveForwardCommand(drivetrain, -30),
                new TurnToCommand(drivetrain, 270),
                new TurnCommand(drivetrain, -5),
                new DriveForwardCommand(drivetrain, 125)
        );
    }
}