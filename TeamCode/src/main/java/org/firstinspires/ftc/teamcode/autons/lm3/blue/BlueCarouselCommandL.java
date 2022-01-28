package org.firstinspires.ftc.teamcode.autons.lm3.blue;

//bottom level

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.FastDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.IMUTurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class BlueCarouselCommandL extends SequentialCommandGroup {
    public BlueCarouselCommandL(Drivetrain drivetrain, Lift lift, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(


                new SplineCommand(drivetrain, new Vector2d(5, 4), Math.toRadians(147), false),
                new IMUTurnCommand(drivetrain, 147),
                new InstantCommand(duckWheels::spinBlueAuton),
                new KindaSlowDriveForwardCommand(drivetrain, 4),
                new WaitCommand(1500),
                new InstantCommand(duckWheels::stop),
                new DriveForwardCommand(drivetrain, -2),
                new IMUTurnCommand(drivetrain, 180),
                new SplineCommand(drivetrain, new Vector2d(17, -0), Math.toRadians(65), true),
                new WaitCommand(2000),
                new IMUTurnCommand(drivetrain, 65),
                new InstantCommand(lift::liftLow),
                new DriveForwardCommand(drivetrain, -3),//might need changing
                new InstantCommand(lift::toggleDel),
                new DriveForwardCommand(drivetrain, 3),
                new SplineCommand(drivetrain, new Vector2d(6, 6), Math.toRadians(180), false)

        );
    }
}