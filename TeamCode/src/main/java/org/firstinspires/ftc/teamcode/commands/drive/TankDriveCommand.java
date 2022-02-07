package org.firstinspires.ftc.teamcode.commands.drive;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

import java.util.Set;
import java.util.function.DoubleSupplier;

public class TankDriveCommand extends CommandBase {
    private Drivetrain drive;
    private GamepadEx driverGamepad;

    protected double multiplier;
    protected double rotMultiplier;

    public TankDriveCommand(Drivetrain drive, GamepadEx driverGamepad) {

        this.drive = drive;
        this.driverGamepad = driverGamepad;

        this.multiplier = 1;
        this.rotMultiplier = 0.75;
        addRequirements(this.drive);
    }

    @Override
    public void execute() {
        // Arcade Drive
        drive.tankDrive(driverGamepad.getLeftY() * multiplier, driverGamepad.getRightY() * multiplier);

        // Tank Drive
        //https://github.com/FTCLib/RoadRunner-FTCLib-Quickstart/blob/main/TeamCode/src/main/java/org/firstinspires/ftc/teamcode/commands/MecanumDriveCommand.java
        //drive.tankDrive(driverGamepad.getLeftY() * multiplier, driverGamepad.getRightY() * multiplier);
        // Mecanum drive
        //drive.drive(-driverGamepad.getLeftY() * multiplier, driverGamepad.getLeftX() * multiplier, driverGamepad.getRightX() * multiplier);
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }
}
