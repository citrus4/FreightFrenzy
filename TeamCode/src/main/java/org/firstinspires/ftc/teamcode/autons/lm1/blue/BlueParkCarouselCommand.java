package org.firstinspires.ftc.teamcode.autons.lm1.blue;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.auton.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class BlueParkCarouselCommand extends SequentialCommandGroup {
    public BlueParkCarouselCommand(Drivetrain drivetrain, Intake intake, Telemetry telemetry) {
        //declare variables here

        addCommands(
                new DriveForwardCommand(drivetrain, 25),
                new TurnToCommand(drivetrain, -93, true),
                new DriveForwardCommand(drivetrain, -125)
        );
    }
}