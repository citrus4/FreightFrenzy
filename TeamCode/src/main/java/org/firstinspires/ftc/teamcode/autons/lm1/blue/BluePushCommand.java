package org.firstinspires.ftc.teamcode.autons.lm1.blue;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SlowestDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.TurnCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class BluePushCommand extends SequentialCommandGroup {
    public BluePushCommand(Drivetrain drivetrain, Intake intake, Telemetry telemetry) {
        //declare variables here

        addCommands(
                //new InstantCommand(intake::halfIntakeRed, intake),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1000),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1000),
                new SlowestDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1000),

                new InstantCommand(intake::stop, intake),
                new TurnCommand(drivetrain, -35),
                new KindaSlowDriveForwardCommand(drivetrain, -50),
                new TurnCommand(drivetrain, 43),
                new DriveForwardCommand(drivetrain, -110)
        );
    }
}