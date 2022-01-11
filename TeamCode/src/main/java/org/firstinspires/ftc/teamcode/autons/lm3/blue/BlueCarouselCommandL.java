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
                new SplineCommand(drivetrain, new Vector2d(14, 5), Math.toRadians(130), false),
                new IMUTurnCommand(drivetrain, 130),
                new InstantCommand(duckWheels::spinBoth),
                new KindaSlowDriveForwardCommand(drivetrain, 1),
                new WaitCommand(1500),
                new InstantCommand(duckWheels::stop)
        );
    }
}