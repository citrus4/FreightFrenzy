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
    protected double rotMultiplier;

    public CapManualCommand(Cap cap, GamepadEx operatorGamepad) {

        this.cap = cap;
        this.operatorGamepad = operatorGamepad;

        this.multiplier = 0.005;
        addRequirements(this.cap);
    }

    @Override
    public void execute() {
        // Arcade Drive
        cap.capWithJoystick(operatorGamepad.getLeftY() * multiplier);

        // Tank Drive
        //https://github.com/FTCLib/RoadRunner-FTCLib-Quickstart/blob/main/TeamCode/src/main/java/org/firstinspires/ftc/teamcode/commands/MecanumDriveCommand.java
        //drive.tankDrive(driverGamepad.getLeftY() * multiplier, driverGamepad.getRightY() * multiplier);
        // Mecanum drive
        //drive.drive(-driverGamepad.getLeftY() * multiplier, driverGamepad.getLeftX() * multiplier, driverGamepad.getRightX() * multiplier);
    }
/*
    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }
 */
}
