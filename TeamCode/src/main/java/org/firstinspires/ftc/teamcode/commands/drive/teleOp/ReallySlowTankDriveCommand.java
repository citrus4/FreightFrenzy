package org.firstinspires.ftc.teamcode.commands.drive.teleOp;

import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class ReallySlowTankDriveCommand extends TankDriveCommand {
    public ReallySlowTankDriveCommand(Drivetrain drive, GamepadEx driverGamepad) {
        super(drive, driverGamepad);
        this.multiplier = 0.15;
    }
}