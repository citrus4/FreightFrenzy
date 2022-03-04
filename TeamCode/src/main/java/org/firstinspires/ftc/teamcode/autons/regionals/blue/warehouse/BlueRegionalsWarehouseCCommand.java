package org.firstinspires.ftc.teamcode.autons.regionals.blue.warehouse;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.acmerobotics.roadrunner.geometry.Vector2d;
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

public class BlueRegionalsWarehouseCCommand extends SequentialCommandGroup {
    public BlueRegionalsWarehouseCCommand(Drivetrain drivetrain, Lift lift, Intake intake, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //testing blue warehouse new
                new InstantCommand(lift::closeDel),
                //go to hub
                new SplineCommand(drivetrain, new Vector2d( 28.5, -20.5),220, true),
                new WaitCommand(50),
                new DriveForwardCommand(drivetrain,-2),
                new TurnToCommand(drivetrain, 180, false),
                new InstantCommand(lift::liftMidAuton),
                new WaitCommand(500),
                new InstantCommand(lift::openDel),
                new DriveForwardCommand(drivetrain, 5),
                new WaitCommand(400),
                new InstantCommand(lift::liftLow),
                new InstantCommand(lift::closeDel),
                new InstantCommand(intake::intake),
                new TwoSplineCommand(drivetrain, new Vector2d(-2,10), new Vector2d(-3, 40.0), 265.8, 264.5),
                new WaitCommand(50),

                new TurnToCommand(drivetrain, 100, false),

                //wait a bit and outtake
                new WaitCommand(200),
                new InstantCommand(intake::outtake),


                //turn to correct
                new TurnToCommand(drivetrain, 85, false),


                new TwoSplineCommand(drivetrain, new Vector2d(-4,10), new Vector2d(22,-19.5), 180,220, true),
                new InstantCommand(intake::stop),
                new TurnToCommand(drivetrain, 170, false),
                new DriveForwardCommand(drivetrain, -3),
                new InstantCommand(lift::liftHigh),
                new WaitCommand(400),
                new InstantCommand(lift::openDel),
                new DriveForwardCommand(drivetrain, 5),
                new InstantCommand(lift::liftLow),
                new InstantCommand(lift::closeDel),
                new WaitCommand(150),
                new InstantCommand(intake::intake),
                new TwoSplineCommand(drivetrain, new Vector2d(-3.5,10), new Vector2d(-3.5, 43.0), 265.8, 264.5),
                //wait a bit and outtake
                new WaitCommand(100),
                new InstantCommand(intake::outtake),
                //stop intake
                new TwoSplineCommand(drivetrain, new Vector2d(-4.5,10), new Vector2d(21,-19.5), 180,220, true),
                new InstantCommand(intake::stop),
                new TurnToCommand(drivetrain, 160, false),
                new DriveForwardCommand(drivetrain, -3),
                new InstantCommand(lift::liftHigh),
                new WaitCommand(400),
                new InstantCommand(lift::openDel),
                new WaitCommand(200),
                new DriveForwardCommand(drivetrain, 5),
                new InstantCommand(lift::closeDel),
                new InstantCommand(lift::liftLow),

                new WaitCommand(200),
                new InstantCommand(intake::intake),
                new TwoSplineCommand(drivetrain, new Vector2d(-2,5), new Vector2d(-3, 42.0), 265.8, 264.5),
                new WaitCommand(400),
                new InstantCommand(intake::outtake)
                //wait a bit and outtake
        );
    }
}
