package org.firstinspires.ftc.teamcode.autons.lm2.red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.auton.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TurnCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class RedCaroParkCommand extends SequentialCommandGroup {
    public RedCaroParkCommand(Drivetrain drivetrain, Lift lift, Telemetry telemetry) {
        //declare variables here


        addCommands(
                new InstantCommand(lift::toggleDel),
                new DriveForwardCommand(drivetrain, 17),
                new TurnCommand(drivetrain, -89),
                new DriveForwardCommand(drivetrain,100)
        );
    }
}