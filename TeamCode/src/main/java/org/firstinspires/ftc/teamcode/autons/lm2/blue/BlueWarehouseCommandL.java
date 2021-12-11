package org.firstinspires.ftc.teamcode.autons.lm2.blue;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.FastDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class BlueWarehouseCommandL extends SequentialCommandGroup {
    public BlueWarehouseCommandL(Drivetrain drivetrain, Lift lift, Telemetry telemetry) {
        //declare variables here


        addCommands(
                new InstantCommand(lift::toggleClosed),
                new DriveForwardCommand(drivetrain, -8),
                new TurnCommand(drivetrain, -35),
                //drive to shipping hub
                new DriveForwardCommand(drivetrain, -21),
                //lift to correct pos
                //open delivery
                new InstantCommand(lift::toggleOpen),
                new WaitCommand(1000),
                new InstantCommand(lift::toggleClosed),
                //back up
                new DriveForwardCommand(drivetrain, 14),
                //turn towards warehouse
                new TurnCommand(drivetrain, 118),
                //park - speed
                new FastDriveCommand(drivetrain, -53)
        );
    }
}