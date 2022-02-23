package org.firstinspires.ftc.teamcode.autons.champs.red.warehouse;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class WarehouseRedCommandR extends SequentialCommandGroup {
    public WarehouseRedCommandR(Drivetrain drivetrain, Lift lift, Intake intake, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //testing blue warehousenew

                //go to warehouse
                new InstantCommand(lift::closeDel),
                new SplineCommand(drivetrain, new Vector2d( 11.25, -10),220, true),
                new WaitCommand(50),

                //to hub
                new TurnToCommand(drivetrain, 180, false),
                new KindaSlowDriveForwardCommand(drivetrain, -5),

                //deliver and spline away
                new InstantCommand(lift::liftHigh),
                //begin sequence
                new InstantCommand(lift::openDel),
                new WaitCommand(400),

                new SplineCommand(drivetrain, new Vector2d(-2,0),40,false),
                new InstantCommand(lift::closeDel),

                //intake on
                new InstantCommand(intake::intake),

                //drive into warehouse
                new DriveForwardCommand(drivetrain, 29),

                //wait a bit
                new WaitCommand(1300),

                //turn
                new TurnToCommand(drivetrain, 92, false),
                new InstantCommand(intake::outtake),
                new WaitCommand(500),

                //drive out of warehouse
                new DriveForwardCommand(drivetrain, -25),

                //stop intake
                new InstantCommand(intake::stop),
                //to hub
                new TurnToCommand(drivetrain, 120, false),
                new SplineCommand(drivetrain, new Vector2d( 9.5, -14),225, true),

                //turn to correct
                new TurnToCommand(drivetrain, 180, false),

                //lift correct pos
                new InstantCommand(lift::liftHigh),
                new WaitCommand(700),
                new InstantCommand(lift::openDel),
                new WaitCommand(700),
                new DriveForwardCommand(drivetrain,2),
                new InstantCommand(lift::closeDel),
                new LowerLiftCommand(lift),
                new InstantCommand(lift::closeDel),

                //park
                new SplineCommand(drivetrain, new Vector2d(-3,0.5),40,false),
                new DriveForwardCommand(drivetrain, 29),

                //intake
                new InstantCommand(intake::intake),
                new WaitCommand(2000),
                new InstantCommand(intake::outtake),
                new WaitCommand(2000),
                new InstantCommand(intake::stop)
        );
    }
}
