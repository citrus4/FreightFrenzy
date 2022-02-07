package org.firstinspires.ftc.teamcode.autons.champs.blue.warehouse;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.hardware.ams.AMSColorSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TwoSplineCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class WarehouseBlueCommandL extends SequentialCommandGroup {
    public WarehouseBlueCommandL(Drivetrain drivetrain, Lift lift, Intake intake, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //testing blue warehousenew

                //go to warehouse
                new InstantCommand(lift::closeDel),
                new SplineCommand(drivetrain, new Vector2d( 11, -10.0),220, true),
                new WaitCommand(50),

                //to hub
                new TurnToCommand(drivetrain, 180, false),
                new KindaSlowDriveForwardCommand(drivetrain, -5),

                //deliver and spline away
                new InstantCommand(lift::liftLow),
                //begin sequence
                new InstantCommand(lift::openDel),
                new WaitCommand(300),
                new TwoSplineCommand(drivetrain, new Vector2d(-2, -10.0), new Vector2d(-2, 26.0), 265.8, 265.8),
                new InstantCommand(lift::closeDel),
                new InstantCommand(intake::intake),



                //wait a bit
                new WaitCommand(500),

                //turn
                new InstantCommand(intake::outtake),

                //drive out of warehouse
                new TwoSplineCommand(drivetrain, new Vector2d(-1.5, -10.0), new Vector2d(12.0, -14.0), 265.8, 225, true),

                //stop intake
                new InstantCommand(intake::stop),
                //to hub

               //turn to correct
                new TurnToCommand(drivetrain, 180, false),

                //lift correct pos
                new InstantCommand(lift::liftHigh),
                new WaitCommand(550),
                new InstantCommand(lift::openDel),
                new WaitCommand(250),
                new DriveForwardCommand(drivetrain,2),
                new InstantCommand(lift::closeDel),
                new LowerLiftCommand(lift),
                new InstantCommand(lift::closeDel),

                //park
                new SplineCommand(drivetrain, new Vector2d(-3,0.5),40,false),
                new DriveForwardCommand(drivetrain, 29)

              /*  //intake
                new InstantCommand(intake::intake),
                new WaitCommand(2000),
                new InstantCommand(intake::outtake),
                new WaitCommand(2000),
                new InstantCommand(intake::stop */

        );
    }
}
