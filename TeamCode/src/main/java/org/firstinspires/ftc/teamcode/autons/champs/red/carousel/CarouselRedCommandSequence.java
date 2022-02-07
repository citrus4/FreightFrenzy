package org.firstinspires.ftc.teamcode.autons.champs.red.carousel;


import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.IMUTurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowestDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class CarouselRedCommandSequence extends SequentialCommandGroup {
    public CarouselRedCommandSequence(Drivetrain drivetrain, Lift lift, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //finished 1/28
                //duck
                //duck
                new InstantCommand(lift::closeDel),
                new KindaSlowDriveForwardCommand(drivetrain, -15),
                new TurnToCommand(drivetrain, 131),
                new SlowDriveForwardCommand(drivetrain, 18.8),
                new InstantCommand(duckWheels::spinRedAuton),
                new ParallelCommandGroup(
                        new SlowestDriveForwardCommand(drivetrain, 7),
                        new WaitCommand(3500)
                ),
                new InstantCommand(duckWheels::stop),
                new DriveForwardCommand(drivetrain, -5),
                new IMUTurnCommand(drivetrain, 0)
        );
    }
}