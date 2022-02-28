package org.firstinspires.ftc.teamcode.commands.drive;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Cap;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class CapManualCommand extends CommandBase {
    private Cap cap;
    private GamepadEx operatorGamepad;

    protected double multiplier;

    public CapManualCommand(Cap cap, GamepadEx operatorGamepad) {
        this.cap = cap;
        this.operatorGamepad = operatorGamepad;

        this.multiplier = 0.017;
        addRequirements(this.cap);
    }

    @Override
    public void execute() {
        cap.capWithJoystick(operatorGamepad.getRightY() * multiplier);
    }
/*
    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }
 */
}
