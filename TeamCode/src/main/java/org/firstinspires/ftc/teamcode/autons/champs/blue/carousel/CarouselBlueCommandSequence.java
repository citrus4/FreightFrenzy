package org.firstinspires.ftc.teamcode.autons.champs.blue.carousel;


import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.IMUTurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.SlowestDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class CarouselBlueCommandSequence extends SequentialCommandGroup {
    public CarouselBlueCommandSequence(Drivetrain drivetrain, Lift lift, DuckWheels duckWheels, Telemetry telemetry) {
        addCommands(
                //finished 1/27
                //duck
                new InstantCommand(lift::closeDel),
                new KindaSlowDriveForwardCommand(drivetrain, -15),
                new TurnToCommand(drivetrain, 229),
                new SlowDriveForwardCommand(drivetrain, 20),
                new InstantCommand(duckWheels::spinBlueAuton),
                new ParallelCommandGroup(
                        new SlowestDriveForwardCommand(drivetrain, 4),
                        new WaitCommand(3500)
                ),
                new InstantCommand(duckWheels::stop),
                new DriveForwardCommand(drivetrain, -5),
                new IMUTurnCommand(drivetrain, -0)
        );
    }
}