package org.firstinspires.ftc.teamcode.autons.regionals.blue.warehouse;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.auton.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TwoSplineCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class BlueRegionalsWarehouseC extends SequentialCommandGroup {
    public BlueRegionalsWarehouseC(Drivetrain drivetrain, Lift lift, Intake intake, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //testing blue warehouse new


                new InstantCommand(lift::closeDel),
                //go to hub
                new SplineCommand(drivetrain, new Vector2d( 11, -11.0),220, true),
                new WaitCommand(50),
                new TurnToCommand(drivetrain, 180, false),
                new DriveForwardCommand(drivetrain, -4),


                //deliver and spline away
                new InstantCommand(lift::liftMid),
                new WaitCommand(250),
                new InstantCommand(lift::openDel),
                new WaitCommand(500),
                new DriveForwardCommand(drivetrain, 3),
                new InstantCommand(lift::liftLow),
                new TwoSplineCommand(drivetrain, new Vector2d(-1.5, -10.0), new Vector2d(-2, 19.0), 265.8, 264.5),
                new InstantCommand(lift::closeDel),
                new WaitCommand(50),
                new InstantCommand(intake::intake),
                new TurnToCommand(drivetrain, 90, false),

                //wait a bit and outtake
                new WaitCommand(750),
                new InstantCommand(intake::outtake),

                new WaitCommand(1500),
                //stop intake
                new InstantCommand(intake::stop),

                //turn to correct
                new TurnToCommand(drivetrain, 85, false)
        );
    }
}