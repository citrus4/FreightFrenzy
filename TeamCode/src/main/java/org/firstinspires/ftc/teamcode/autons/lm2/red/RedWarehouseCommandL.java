package org.firstinspires.ftc.teamcode.autons.lm2.red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.teleOp.FastDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.TurnCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class RedWarehouseCommandL extends SequentialCommandGroup {
    public RedWarehouseCommandL(Drivetrain drivetrain, Lift lift, Telemetry telemetry) {
        //declare variables here


        addCommands(
                new InstantCommand(lift::toggleDel),
                new DriveForwardCommand(drivetrain, -8),
                new TurnCommand(drivetrain, 90),
                //drive to shipping hub
                new DriveForwardCommand(drivetrain, -21),
                new TurnCommand(drivetrain, -90),
                new DriveForwardCommand(drivetrain, -15),
                //lift to corredt pos
                //open delivery
                new InstantCommand(lift::toggleDel),
                new WaitCommand(1250),
                new InstantCommand(lift::toggleDel),
                //back up
                new DriveForwardCommand(drivetrain, 8),
                //turn towards warehouse
                new TurnCommand(drivetrain, -90),
                //park
                new FastDriveCommand(drivetrain, -65)
        );
    }
}