package org.firstinspires.ftc.teamcode.autons.lm2.red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.FastDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class RedWarehouseCommandR extends SequentialCommandGroup {
    public RedWarehouseCommandR(Drivetrain drivetrain, Lift lift, Telemetry telemetry) {
        //declare variables here


        addCommands(
                new DriveForwardCommand(drivetrain, -8),
                new TurnCommand(drivetrain, 30),
                //drive to shipping hub
                new DriveForwardCommand(drivetrain, -21),
                //lift to corredt pos
                //open delivery
                new InstantCommand(lift::autonOpenDelivery),
                new WaitCommand(1000),
                new InstantCommand(lift::closeDelivery),
                //back up
                new DriveForwardCommand(drivetrain, 12),
                //turn towards warehouse
                new TurnCommand(drivetrain, -120),
                //park - speed
                new FastDriveCommand(drivetrain, -53)
        );
    }
}