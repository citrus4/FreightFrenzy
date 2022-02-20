package org.firstinspires.ftc.teamcode.commands.drive.teleOp;

import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class SlowTankDriveCommand extends TankDriveCommand {
    public SlowTankDriveCommand(Drivetrain drive, GamepadEx driverGamepad) {
        super(drive, driverGamepad);
        this.multiplier = 0.25;
    }
}