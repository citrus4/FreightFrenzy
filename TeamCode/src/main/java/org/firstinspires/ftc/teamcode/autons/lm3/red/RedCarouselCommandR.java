package org.firstinspires.ftc.teamcode.autons.lm3.red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.auton.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class RedCarouselCommandR extends SequentialCommandGroup {
    public RedCarouselCommandR(Drivetrain drivetrain, Intake intake, DuckWheels duckWheels, Lift lift, Telemetry telemetry) {
        addCommands(
                new DriveForwardCommand(drivetrain, 24),
                new TurnToCommand(drivetrain,-50, true),
                new DriveForwardCommand(drivetrain,15),
                new InstantCommand(lift::liftHigh),
                new WaitCommand(1000),
                new InstantCommand(lift::openDel),

                //carasoul
                new InstantCommand(lift::liftLow),
                new DriveForwardCommand(drivetrain, -55),
                new KindaSlowDriveForwardCommand(drivetrain, -3),
                new InstantCommand(duckWheels::spinDuckRed),
                new WaitCommand(5000),
                new InstantCommand(duckWheels::stop),

                new TurnToCommand(drivetrain, 0),
                new DriveForwardCommand(drivetrain, 24),
                new TurnToCommand(drivetrain, -90,true),
                new DriveForwardCommand(drivetrain, 5)

        );
    }
}