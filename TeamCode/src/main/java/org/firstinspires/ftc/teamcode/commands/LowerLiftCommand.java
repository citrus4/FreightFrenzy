package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class LowerLiftCommand extends SequentialCommandGroup {
    private Lift lift;

    public LowerLiftCommand(Lift lift) {
        addCommands(
                new InstantCommand(lift::liftResting, lift),
                new InstantCommand(lift::closeDelivery, lift)
        );
    }
}
