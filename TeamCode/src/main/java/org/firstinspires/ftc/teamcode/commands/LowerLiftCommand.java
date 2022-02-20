package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class LowerLiftCommand extends SequentialCommandGroup {
    private Lift lift;

    public LowerLiftCommand(Lift lift) {
        addCommands(
                /*
            new InstantCommand(lift::toggleDel, lift),
            new InstantCommand(lift::liftMid, lift),
            new InstantCommand(lift::lowerLiftManual, lift),

            new WaitUntilCommand(lift::atBottom),
            new InstantCommand(lift::stopAtBottom)

                 */
        );
    }
}
