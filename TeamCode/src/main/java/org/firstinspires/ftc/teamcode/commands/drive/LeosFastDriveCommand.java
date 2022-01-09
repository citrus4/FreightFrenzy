package org.firstinspires.ftc.teamcode.commands.drive;

import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class LeosFastDriveCommand extends DefaultDriveCommand {
    public LeosFastDriveCommand(Drivetrain drive, GamepadEx driverGamepad) {
        super(drive, driverGamepad);
        this.multiplier = 1.0;
        this.rotMultiplier = 0.5;
    }
}