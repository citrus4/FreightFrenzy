package org.firstinspires.ftc.teamcode.autons.champs.red.carousel;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class CarouselRedCommandR extends SequentialCommandGroup {
    public CarouselRedCommandR(Drivetrain drivetrain, Lift lift, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //RIGHT red carosuel
                //command sequence
                //duck
                // perfect
                new CarouselRedCommandSequence(drivetrain, lift, duckWheels, telemetry),


                //--------------------end command sequence------------------------------------------
                //--------------------------finished------------------------------------------------

                //deliver pre-load
                //left(low)
                new SplineCommand(drivetrain, new Vector2d(25, -5.4), 230, true),
                new WaitCommand(200),

                //new IMUTurnCommand(drivetrain, 135, true),
                new TurnToCommand(drivetrain, 40, true),
                new InstantCommand(lift::liftHigh),

                new SlowDriveForwardCommand(drivetrain, -7.7),
                new WaitCommand(200),

                new InstantCommand(lift::toggleDel),
                new WaitCommand(700),
                new SlowDriveForwardCommand(drivetrain, 8),
                new InstantCommand(lift::LowerLiftCommand),

                //park
                new TurnToCommand(drivetrain, -90),
                new SplineCommand(drivetrain,new Vector2d( 13.8, 18.5), -270, true)

        );
    }
}
