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

public class BlueWarehouseCommandC extends SequentialCommandGroup {
    public BlueWarehouseCommandC(Drivetrain drivetrain, Lift lift, Telemetry telemetry) {
        //declare variables here


        addCommands(
                new InstantCommand(lift::toggleClosed),
                new DriveForwardCommand(drivetrain, -8),
                new TurnCommand(drivetrain, -90),
                //drive to shipping hub
                new DriveForwardCommand(drivetrain, -20),
                new TurnCommand(drivetrain, 92),
                new DriveForwardCommand(drivetrain, -15),
                //lift to correct pos ---------------------------------------
                new InstantCommand(lift::liftMid),
                //open delivery
                new DriveForwardCommand(drivetrain, -2),
                new WaitCommand(750),
                new InstantCommand(lift::toggleOpen),
                new WaitCommand(1250),
                new InstantCommand(lift::toggleClosed),
                //back up
                new DriveForwardCommand(drivetrain, 8.5),
                new InstantCommand(lift::liftLow),
                //turn towards warehouse
                new TurnCommand(drivetrain, 88),
                //park
                new FastDriveCommand(drivetrain, -72)
        );
    }
}