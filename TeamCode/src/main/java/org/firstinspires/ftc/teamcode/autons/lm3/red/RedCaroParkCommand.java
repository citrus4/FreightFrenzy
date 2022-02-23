package org.firstinspires.ftc.teamcode.autons.lm3.red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.auton.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class RedCaroParkCommand extends SequentialCommandGroup {
    public RedCaroParkCommand(Drivetrain drivetrain, Intake intake, DuckWheels duckWheels, Lift lift, Telemetry telemetry) {
        addCommands(
                new InstantCommand(lift::closeDel),
                new DriveForwardCommand(drivetrain, 25),
                new TurnToCommand(drivetrain,-90),
                new WaitCommand(1000),
                new DriveForwardCommand(drivetrain,25)
        );
    }
}
