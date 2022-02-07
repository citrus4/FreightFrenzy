package org.firstinspires.ftc.teamcode.autons.champs.red.warehouse;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class WarehouseRedCommandL extends SequentialCommandGroup {
    public WarehouseRedCommandL(Drivetrain drivetrain, Lift lift, Intake intake, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //testing red warehouse
                //command sequence
                //delivery
                //new CarouselRedCommandSequence(drivetrain, lift, duckWheels, telemetry),


                //--------------------end command sequence------------------------------------------
                //--------------------------finished------------------------------------------------
                //Left Red Warehouse
                //deliver pre-load
                //left(low)
                new InstantCommand(lift::closeDel),
                new SplineCommand(drivetrain, new Vector2d( 15, 12.5),220, true),
                //14, 11 perfect red ware house                // new SplineCommand(drivetrain, new Vector2d(-5, -10), 130, true),

                new WaitCommand(200),

                //new IMUTurnCommand(drivetrain, 135, true),
                new TurnToCommand(drivetrain, 180, false),
                new InstantCommand(lift::liftLow),
                //new KindaSlowDriveForwardCommand(drivetrain, -2),
                new InstantCommand(lift::openDel),
                new WaitCommand(700),
                new SplineCommand(drivetrain, new Vector2d(-2,0),180,false),
                new InstantCommand(lift::closeDel),

                new TurnToCommand(drivetrain, -100, true),

                new InstantCommand(intake::intake),
                new DriveForwardCommand(drivetrain, 22),
                new WaitCommand(1500),
                //
                new InstantCommand(intake::stop),
                new TurnToCommand(drivetrain, -80, true),
                new InstantCommand(intake::outtake),
                new DriveForwardCommand(drivetrain, -23),//-20
                //
                new InstantCommand(intake::stop),
                new DriveForwardCommand(drivetrain, 2),
                new SplineCommand(drivetrain, new Vector2d(9.5, 12.5), 240, true),//was 220
                new TurnToCommand(drivetrain, 180),
                new InstantCommand(lift::liftHigh),
                //towards hub -2
                new DriveForwardCommand(drivetrain, -8),
                new WaitCommand(500),
                new InstantCommand(lift::openDel),
                new WaitCommand(750),
                new InstantCommand(lift::LowerLiftCommand),
                new SplineCommand(drivetrain, new Vector2d(-2,0), 200),
                //down for agle closer to wall
                //stopping short of hub(4inches) on 2nd cycle

                new InstantCommand(lift::closeDel),

                new TurnToCommand(drivetrain, -100, true),

                new InstantCommand(intake::intake),
                new DriveForwardCommand(drivetrain, 25),
                new WaitCommand(2500),
                new InstantCommand(intake::stop),
                new TurnToCommand(drivetrain, -80, true),
                new InstantCommand(intake::outtake),
                new DriveForwardCommand(drivetrain, -20),
                new InstantCommand(intake::stop),
                new DriveForwardCommand(drivetrain, 2),
                new SplineCommand(drivetrain, new Vector2d(9.5, 12.5), 180, true),//x should be hiher, y should be higher
                new InstantCommand(lift::liftHigh),
                new DriveForwardCommand(drivetrain, -3),
                new WaitCommand(500),
                new InstantCommand(lift::openDel),
                new WaitCommand(750),
                new InstantCommand(lift::LowerLiftCommand)
        //should be like 21
                //new SlowDriveForwardCommand(drivetrain, -4.75),//perfect distance
                //new WaitCommand(200),

             /*   new InstantCommand(lift::toggleDel),
                new WaitCommand(700),
                new SlowDriveForwardCommand(drivetrain, 8.5),
                new InstantCommand(lift::LowerLiftCommand),

                //park
                new TurnToCommand(drivetrain, -90),
                new SplineCommand(drivetrain,new Vector2d( 13, 16), -270, true) */
        );
    }
}
