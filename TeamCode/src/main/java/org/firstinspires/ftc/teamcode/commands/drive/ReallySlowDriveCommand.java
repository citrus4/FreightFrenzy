package org.firstinspires.ftc.teamcode.commands.drive;

import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class ReallySlowDriveCommand extends DefaultDriveCommand {
    public ReallySlowDriveCommand(Drivetrain drive, GamepadEx driverGamepad) {
        super(drive, driverGamepad);
        this.multiplier = 0.1;
    }
}