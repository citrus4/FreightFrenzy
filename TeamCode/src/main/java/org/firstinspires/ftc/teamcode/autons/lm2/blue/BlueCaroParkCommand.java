package org.firstinspires.ftc.teamcode.autons.lm2.blue;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class BlueCaroParkCommand extends SequentialCommandGroup {
    public BlueCaroParkCommand(Drivetrain drivetrain, Lift lift, Telemetry telemetry) {
        //declare variables here


        addCommands(
                new InstantCommand(lift::closeDelivery),
                new DriveForwardCommand(drivetrain, 17),
                new TurnCommand(drivetrain, 92),
                new DriveForwardCommand(drivetrain,100)
        );
    }
}