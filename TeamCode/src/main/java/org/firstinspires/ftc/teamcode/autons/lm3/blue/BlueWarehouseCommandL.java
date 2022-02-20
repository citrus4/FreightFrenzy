package org.firstinspires.ftc.teamcode.autons.lm3.blue;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.teleOp.FastDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.TurnCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class BlueWarehouseCommandL extends SequentialCommandGroup {
    public BlueWarehouseCommandL(Drivetrain drivetrain, Lift lift, Telemetry telemetry) {
        addCommands(
                new InstantCommand(lift::closeDel),
                new DriveForwardCommand(drivetrain, 8),
                new TurnCommand(drivetrain, 35),
                //drive to shipping hub
                new DriveForwardCommand(drivetrain, 21),
                //lift to correct pos
                //open delivery
                new InstantCommand(lift::openDel),
                new WaitCommand(1000),
                new InstantCommand(lift::closeDel),
                //back up
                new DriveForwardCommand(drivetrain, -14.5),
                //turn towards warehouse
                new TurnCommand(drivetrain, -118),
                //park - speed
                new FastDriveCommand(drivetrain, 53)

        );
    }
}