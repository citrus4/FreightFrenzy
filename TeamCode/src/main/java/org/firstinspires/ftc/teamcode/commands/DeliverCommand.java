package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.commands.drive.atuon.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.atuon.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class DeliverCommand extends SequentialCommandGroup {

    private Drivetrain drivetrain;
    private Lift lift;

    public DeliverCommand(Drivetrain drivetrain, Lift lift) {
        addCommands(
                new ParallelCommandGroup(
                        new DriveForwardCommand(drivetrain, -2),
                        new InstantCommand(lift::openDel, lift)
                )
        );
    }
}
