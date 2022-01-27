package org.firstinspires.ftc.teamcode.autons.champs.blue;

//bottom level

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.IMUTurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SplineCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class CarouselBlueCommandL extends SequentialCommandGroup {
    public CarouselBlueCommandL(Drivetrain drivetrain, Lift lift, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(


                new CarouselBlueCommandSequence(drivetrain, lift, duckWheels, telemetry),
                new InstantCommand(lift::liftLow),
                new SlowDriveForwardCommand(drivetrain, -2),
                new InstantCommand(lift::toggleDel),
                new SlowDriveForwardCommand(drivetrain, 5),
                new InstantCommand(lift::toggleDel),
                new SplineCommand(drivetrain, new Vector2d(6, -1), 90, true),
                new IMUTurnCommand(drivetrain, 90)

            );
    }
}