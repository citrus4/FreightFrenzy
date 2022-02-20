package org.firstinspires.ftc.teamcode.autons.champs.blue.carousel;

//bottom level

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class CarouselBlueCommandC extends SequentialCommandGroup {
    public CarouselBlueCommandC(Drivetrain drivetrain, Lift lift, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //blue high carousel
                //command sequence
                //duck
                new CarouselBlueCommandSequence(drivetrain, lift, duckWheels, telemetry),


                //--------------------end command sequence------------------------------------------
                //--------------------------finished------------------------------------------------

                new SplineCommand(drivetrain, new Vector2d(25, 5.4), -230, true),
                new WaitCommand(200),

                //new IMUTurnCommand(drivetrain, 135, true),
                new TurnToCommand(drivetrain, -60, true),
                new InstantCommand(lift::liftMid),

                new SlowDriveForwardCommand(drivetrain, -7.15),//perfect distance
                new WaitCommand(200),

                new InstantCommand(lift::toggleDel),
                new WaitCommand(700),
                new SlowDriveForwardCommand(drivetrain, 8),
                new LowerLiftCommand(lift),


                //park
                new TurnToCommand(drivetrain, 90, true),
                new SplineCommand(drivetrain,new Vector2d( 14.1, -10), 270, true)

        );
    }
}