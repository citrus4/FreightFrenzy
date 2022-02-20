package org.firstinspires.ftc.teamcode.autons;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

@Disabled
public class TestAutonCommand extends SequentialCommandGroup {
    public TestAutonCommand(Drivetrain drivetrain, Intake intake, DuckWheels duckWheels, Lift lift, Telemetry telemetry) {
        //declare variables here

        addCommands(
                //testing red warehouse
                //command sequence
                //delivery
                //new CarouselRedCommandSequence(drivetrain, lift, duckWheels, telemetry),


                //--------------------end command sequence------------------------------------------
                //--------------------------finished------------------------------------------------

                //deliver pre-load
                //left(low)
                new SplineCommand(drivetrain, new Vector2d( 14, 11),220, true),
               //14, 11 perfect red ware house
               // new SplineCommand(drivetrain, new Vector2d(-5, -10), 130, true),

                new WaitCommand(200),

                //new IMUTurnCommand(drivetrain, 135, true),
                new TurnToCommand(drivetrain, 200, false),
                new InstantCommand(lift::liftLow),

                //new SlowDriveForwardCommand(drivetrain, -4.75),//perfect distance
                //new WaitCommand(200),

                new InstantCommand(lift::toggleDel),
                new WaitCommand(700),
                new SlowDriveForwardCommand(drivetrain, 8.5),
                new LowerLiftCommand(lift),

                //park
                new TurnToCommand(drivetrain, -90),
                new SplineCommand(drivetrain,new Vector2d( 13, 16), -270, true)

        );
    }
}