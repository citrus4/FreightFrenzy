package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.Cap;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class LowerLiftNoLimitSwitchCommand extends SequentialCommandGroup {
    private Lift lift;
    private Cap cap;

    public LowerLiftNoLimitSwitchCommand(Lift lift, Cap cap) {
        addCommands(
                new ParallelCommandGroup(
                    new InstantCommand(cap::rest),
                    new InstantCommand(lift::closeDel, lift)
                ),
            new InstantCommand(lift::liftLow, lift)
        );
    }
}
